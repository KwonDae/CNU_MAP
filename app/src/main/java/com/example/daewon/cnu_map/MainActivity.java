package com.example.daewon.cnu_map;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    ImageButton mapicon,sisulicon,roadicon,eventicon,busicon,touricon;
    NavigationView navigationView;
    private final long FINISH_INTERVAL_TIME = 1000;
    private long backPressedTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //MainActivity

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mapicon = (ImageButton)findViewById(R.id.mapicon);
        sisulicon = (ImageButton)findViewById(R.id.sisulicon);
        roadicon = (ImageButton)findViewById(R.id.roadicon);
        eventicon = (ImageButton)findViewById(R.id.eventicon);
        busicon = (ImageButton)findViewById(R.id.busicon);
        touricon = (ImageButton)findViewById(R.id.touricon);



        drawerLayout = (DrawerLayout)findViewById(R.id.main_drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();


        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.navigation_map:
                        Toast.makeText(MainActivity.this, "Map Click", Toast.LENGTH_SHORT).show();
                        Intent mapIntent = new Intent(MainActivity.this, ShowMap_Activity.class);
                        startActivity(mapIntent);
                        break;

                    case R.id.navigation_road:
                        Toast.makeText(MainActivity.this, "Road Click", Toast.LENGTH_SHORT).show();
                        Intent roadIntent = new Intent(MainActivity.this, FindWay_Activity.class);
                        startActivity(roadIntent);
                        break;
                    case R.id.navigation_sisul:
                        Toast.makeText(MainActivity.this, "Road Click", Toast.LENGTH_SHORT).show();
                        Intent sisulIntent = new Intent(MainActivity.this, AroundArea_Activity.class);
                        startActivity(sisulIntent);
                        break;
                    case R.id.navigation_event:
                        Toast.makeText(MainActivity.this, "Event Click", Toast.LENGTH_SHORT).show();
                        Intent eventIntent = new Intent(MainActivity.this, EventActivity.class);
                        startActivity(eventIntent);
                        break;
                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });



        mapicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShowMap_Activity.class);
                startActivity(intent);

            }
        });

        roadicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FindWay_Activity.class);
                startActivity(intent);
            }
        });

        sisulicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AroundArea_Activity.class);
                startActivity(intent);
            }
        });

        eventicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                startActivity(intent);
            }
        });
        touricon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TourActivity.class);
                startActivity(intent);
            }
        });
        busicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BusActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            long tempTime = System.currentTimeMillis();
            long intervalTime = tempTime - backPressedTime;
            if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime) {
                super.onBackPressed();
            } else {
                backPressedTime = tempTime;
                Toast.makeText(getApplicationContext(), "'뒤로'버튼을 한 번 더 누르면 종료됩니다", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
