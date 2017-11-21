package com.example.daewon.cnu_map;

import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FindWay_Activity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    Spinner spinner_From, spinner_To;
    TextView textView3, textView4;
    Button button;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigationView;
    public double latitude, longitude, latitude2, longitude2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_way_);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinner_From = (Spinner) findViewById(R.id.spinner);
        spinner_To = (Spinner) findViewById(R.id.spinner2);
        spinner_From.setPrompt("출발지를 선택해주세요.");
        spinner_To.setPrompt("목적지를 선택해주세요.");

        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        button = (Button) findViewById(R.id.button);

        drawerLayout = (DrawerLayout) findViewById(R.id.find_way_drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();
                int id = item.getItemId();
                switch (id) {
                    case R.id.navigation_map:
                        Toast.makeText(FindWay_Activity.this, "Map Click", Toast.LENGTH_SHORT).show();
                        Intent mapIntent = new Intent(FindWay_Activity.this, ShowMap_Activity.class);
                        startActivity(mapIntent);
                        finish();
                        break;

                    case R.id.navigation_road:
                        Toast.makeText(FindWay_Activity.this, "Road Click", Toast.LENGTH_SHORT).show();
                        Intent roadIntent = new Intent(FindWay_Activity.this, FindWay_Activity.class);
                        startActivity(roadIntent);
                        finish();
                        break;
                    case R.id.navigation_sisul:
                        Toast.makeText(FindWay_Activity.this, "Road Click", Toast.LENGTH_SHORT).show();
                        Intent sisulIntent = new Intent(FindWay_Activity.this, AroundArea_Activity.class);
                        startActivity(sisulIntent);
                        finish();
                        break;
                    case R.id.navigation_event:
                        Toast.makeText(FindWay_Activity.this, "Event Click", Toast.LENGTH_SHORT).show();
                        Intent eventIntent = new Intent(FindWay_Activity.this, EventActivity.class);
                        startActivity(eventIntent);
                        finish();
                        break;

                }

                return true;
            }
        });

        spinner_From.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Resources r = getResources();
                String[] from = r.getStringArray(R.array.From_where);
                String choice = from[position];
                textView3.setText(choice);
                Toast.makeText(FindWay_Activity.this, choice, Toast.LENGTH_SHORT).show();

                if (position == 0) {
                    latitude = 36.370082;
                    longitude = 127.346223;
                }
                if (position == 1) {
                    latitude = 36.367603;
                    longitude = 127.344742;
                }
                if (position == 2) {
                    latitude = 36.367439;
                    longitude = 127.346160;
                }
                if (position == 3) {
                    latitude = 36.366667;
                    longitude = 127.344359;
                }
                if (position == 4) {
                    latitude = 36.368978;
                    longitude = 127.346882;
                }
                if (position == 5) {
                    latitude = 36.363095;
                    longitude = 127.346031;
                }
                if (position == 6) {
                    latitude = 36.365682;
                    longitude = 127.344672;
                }
                if (position == 7) {
                    latitude = 36.364334;
                    longitude = 127.346321;
                }
                if (position == 8) {
                    latitude = 36.362765;
                    longitude = 127.344839;
                }
                if (position == 9) {
                    latitude = 36.365201;
                    longitude = 127.346612;
                }
                if (position == 10) {
                    latitude = 36.365029;
                    longitude = 127.347682;
                }
                if (position == 11) {
                    latitude = 36.365958;
                    longitude = 127.345839;
                }
                if (position == 12) {
                    latitude = 36.367833;
                    longitude = 127.343307;
                }
                if (position == 13) {
                    latitude = 36.371410;
                    longitude = 127.344823;
                }
                if (position == 14) {
                    latitude = 36.366419;
                    longitude = 127.342217;
                }
                if (position == 15) {
                    latitude = 36.368968;
                    longitude = 127.343181;
                }
                if (position == 16) {
                    latitude = 36.366869;
                    longitude = 127.340166;
                }
                if (position == 17) {
                    latitude = 36.367862;
                    longitude = 127.341175;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_To.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Resources r = getResources();
                String[] to = r.getStringArray(R.array.To_where);
                String choice = to[position];
                textView4.setText(choice);
                Toast.makeText(FindWay_Activity.this, choice, Toast.LENGTH_SHORT).show();

                if (position == 0) {
                    latitude2 = 36.370082;
                    longitude2 = 127.346223;
                }
                if (position == 1) {
                    latitude2 = 36.367603;
                    longitude2 = 127.344742;
                }
                if (position == 2) {
                    latitude2 = 36.367439;
                    longitude2 = 127.346160;
                }
                if (position == 3) {
                    latitude2 = 36.366667;
                    longitude2 = 127.344359;
                }
                if (position == 4) {
                    latitude2 = 36.368978;
                    longitude2 = 127.346882;
                }
                if (position == 5) {
                    latitude2 = 36.363095;
                    longitude2 = 127.346031;
                }
                if (position == 6) {
                    latitude2 = 36.365682;
                    longitude2 = 127.344672;
                }
                if (position == 7) {
                    latitude2 = 36.364334;
                    longitude2 = 127.346321;
                }
                if (position == 8) {
                    latitude2 = 36.362765;
                    longitude2 = 127.344839;
                }
                if (position == 9) {
                    latitude2 = 36.365201;
                    longitude2 = 127.346612;
                }
                if (position == 10) {
                    latitude2 = 36.365029;
                    longitude2 = 127.347682;
                }
                if (position == 11) {
                    latitude2 = 36.365958;
                    longitude2 = 127.345839;
                }
                if (position == 12) {
                    latitude2 = 36.367833;
                    longitude2 = 127.343307;
                }
                if (position == 13) {
                    latitude2 = 36.371410;
                    longitude2 = 127.344823;
                }
                if (position == 14) {
                    latitude2 = 36.366419;
                    longitude2 = 127.342217;
                }
                if (position == 15) {
                    latitude2 = 36.368968;
                    longitude2 = 127.343181;
                }
                if (position == 16) {
                    latitude2 = 36.366869;
                    longitude2 = 127.340166;
                }
                if (position == 17) {
                    latitude2 = 36.367862;
                    longitude2 = 127.341175;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindWay_Activity.this, RoadFInd_Activity.class);
                intent.putExtra("latitude", latitude);
                intent.putExtra("longitude", longitude);
                intent.putExtra("latitude2", latitude2);
                intent.putExtra("longitude2", longitude2);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}
