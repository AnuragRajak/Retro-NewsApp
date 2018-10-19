package arr.com.retrofit2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import arr.com.retrofit2.Hindi.HindiAPI;
import arr.com.retrofit2.Hindi.HindiAdapter;
import arr.com.retrofit2.Hindi.HindiNews;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main5Activity extends AppCompatActivity {
     RecyclerView cv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        getSupportActionBar().setTitle("Hindi News");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cv4=findViewById(R.id.cv4);
        cv4.setLayoutManager(new LinearLayoutManager(this));
        GETData();
    }



    private void GETData()
    {
        Call<HindiNews> hindiNews =HindiAPI.gethindiservice().gethindilist();

        hindiNews.enqueue(new Callback<HindiNews>() {
            @Override
            public void onResponse(Call<HindiNews> call, Response<HindiNews> response)
            {

                HindiNews h1=response.body();
                cv4.setAdapter(new HindiAdapter(Main5Activity.this,h1.getItems()));


            }

            @Override
            public void onFailure(Call<HindiNews> call, Throwable t) {
                Intent i=new Intent(Main5Activity.this,NoInternet.class);
                startActivity(i);            }
        });



    }
}
