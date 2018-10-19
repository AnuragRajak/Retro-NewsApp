package arr.com.retrofit2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import arr.com.retrofit2.CricketNews.CricketAPI;
import arr.com.retrofit2.CricketNews.CricketAdapter;
import arr.com.retrofit2.CricketNews.CricketNews;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main6Activity extends AppCompatActivity {
     RecyclerView cv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        getSupportActionBar().setTitle("Sports Hindi");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cv5=findViewById(R.id.cv5);
        cv5.setLayoutManager(new LinearLayoutManager(this));
        GETData();
    }


    private void GETData()
    {

      Call<CricketNews> cricketNews=CricketAPI.getCricketservice().getcricketlist();

      cricketNews.enqueue(new Callback<CricketNews>() {
          @Override
          public void onResponse(Call<CricketNews> call, Response<CricketNews> response) {
              CricketNews c=response.body();

              cv5.setAdapter(new CricketAdapter(Main6Activity.this,c.getItems()));
          }

          @Override
          public void onFailure(Call<CricketNews> call, Throwable t)
          {
              Intent i=new Intent(Main6Activity.this,NoInternet.class);
              startActivity(i);
          }
      });

    }
}
