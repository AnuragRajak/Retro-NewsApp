package arr.com.retrofit2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main4Activity extends AppCompatActivity {

    RecyclerView cv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getSupportActionBar().setTitle("Sports News");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cv3=findViewById(R.id.cv3);
        cv3.setLayoutManager(new LinearLayoutManager(this));
        GETData();
    }


    private void GETData()
    {

        Call<SportNews> sportNews =SportAPI.getsportservice().getsportlist();

        sportNews.enqueue(new Callback<SportNews>() {
            @Override
            public void onResponse(Call<SportNews> call, Response<SportNews> response)
            {
                SportNews s1=response.body();
                cv3.setAdapter(new SportAdapter(Main4Activity.this,s1.getArticles()));

            }

            @Override
            public void onFailure(Call<SportNews> call, Throwable t) {
                Intent i=new Intent(Main4Activity.this,NoInternet.class);
                startActivity(i);
    }
});


    }


}
