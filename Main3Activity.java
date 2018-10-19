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

public class Main3Activity extends AppCompatActivity {
       RecyclerView cv2;
       AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setTitle("Technology");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cv2=findViewById(R.id.cv2);
        cv2.setLayoutManager(new LinearLayoutManager(this));

        GETData();
    }

     private void GETData() {
         Call<TechnologyNews> technology = TechnologyAPI.gettechnologyservice().gettechnolgylist();

         technology.enqueue(new Callback<TechnologyNews>() {
             @Override
             public void onResponse(Call<TechnologyNews> call, Response<TechnologyNews> response) {

                 TechnologyNews t1 = response.body();
                 cv2.setAdapter(new TechnologyAdapter(Main3Activity.this, t1.getArticles()));


             }

             @Override
             public void onFailure(Call<TechnologyNews> call, Throwable t) {
                 Intent i=new Intent(Main3Activity.this,NoInternet.class);
                 startActivity(i);

             }
         });

     }


}
