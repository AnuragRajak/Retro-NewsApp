package arr.com.retrofit2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.github.florent37.diagonallayout.DiagonalLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SwipeRefreshLayout swipe;
    KenBurnsView kenBurnsView;
    boolean isScrolling =false;
    AlertDialog alertDialog;
    DiagonalLayout diagonalLayout;
    int CurrentItems,TotalItems,ScrollItems;
    PostAdapter adapter;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        alertDialog = new SpotsDialog(this);
        getSupportActionBar().setTitle("Science");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.rc1);
        recyclerView.setHasFixedSize(true);

       recyclerView.setLayoutManager(new LinearLayoutManager(this));


        diagonalLayout = findViewById(R.id.dg1);
        kenBurnsView = findViewById(R.id.kenburn);


        getData();

    }




    private void getData()
    {

        Call<PostList> postlist = ScienceApi.getPostService().getPostList();

        postlist.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {

                PostList pt = response.body();
              recyclerView.setAdapter(new PostAdapter(MainActivity.this,pt.getArticles()));
            }

            @Override
            public void onFailure(Call<PostList> call, Throwable t) {

                Intent i=new Intent(MainActivity.this,NoInternet.class);
                startActivity(i);



            }
        });

    }
}
