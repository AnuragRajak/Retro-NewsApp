package arr.com.retrofit2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import arr.com.retrofit2.AutoMobiles.Main8Activity;
import arr.com.retrofit2.Entertainment.Main9Activity;

public class Main7Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,View.OnClickListener

{

         private CardView Trending,Sports,Technology,Hi_news,All_news;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        Trending=findViewById(R.id.cd1);
        Sports=findViewById(R.id.cd2);
        Technology=findViewById(R.id.cd3);
        Hi_news=findViewById(R.id.cd4);
        All_news=findViewById(R.id.cd5);

        Trending.setOnClickListener(this);
        Sports.setOnClickListener(this);
        Technology.setOnClickListener(this);
        Hi_news.setOnClickListener(this);
        All_news.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else
            {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main7, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.t1)
        {
           Intent cricket=new Intent(this,Main6Activity.class);
            startActivity(cricket);

        }
        else if (id == R.id.t2)
        {
            Intent Auto=new Intent(this,Main8Activity.class);
            startActivity(Auto);

        }
        else if (id == R.id.t3)
        {

            Intent Entertain=new Intent(this, Main9Activity.class);
            startActivity(Entertain);
        }
        else if (id == R.id.t4)
        {


        }
        else if (id == R.id.t5)
        {
           Intent i=new Intent(Intent.ACTION_SEND);
           i.setType("text/plain");
           String shareBody="Retro:NewsApp";
           String shareSub="Get All News In One Place";
           i.putExtra(i.EXTRA_SUBJECT,shareBody);
           i.putExtra(i.EXTRA_TEXT,shareSub);
           startActivity(Intent.createChooser(i,"Share using"));
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v)
    {


        switch (v.getId())
        {

            case R.id.cd1:

                Intent i=new Intent(this,Main2Activity.class);
                startActivity(i);
                break;


            case R.id.cd2:
                Intent i2=new Intent(this,Main4Activity.class);
                startActivity(i2);
                break;

            case R.id.cd3:
                Intent i3=new Intent(this,Main3Activity.class);
                startActivity(i3);
                break;



            case R.id.cd4:
                Intent i4=new Intent(this,Main5Activity.class);
                startActivity(i4);
                break;

            case R.id.cd5:
                Intent i5=new Intent(this,MainActivity.class);
                startActivity(i5);
                break;

        }


    }
}
