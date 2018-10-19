package arr.com.retrofit2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {
    RecyclerView cv1;
    AlertDialog ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setTitle("Trending");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cv1=findViewById(R.id.cv1);
        cv1.setLayoutManager(new LinearLayoutManager(this));

        GetData();
    }
    public void GetData()
    {
         Call<TimesIndia> times=   TimesAPI.gettimesservice().gettimeslist();
              times.enqueue(new Callback<TimesIndia>() {
                  @Override
                  public void onResponse(Call<TimesIndia> call, Response<TimesIndia> response)
                  {              TimesIndia t1=response.body();
                            cv1.setAdapter(new TimesAdapter(Main2Activity.this,t1.getArticles()));
                  }

                  @Override
                  public void onFailure(Call<TimesIndia> call, Throwable t)
                  { Intent i=new Intent(Main2Activity.this,NoInternet.class);
                      startActivity(i);
                  }
              });
    }
}
