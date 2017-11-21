package com.example.daewon.cnu_map;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TourActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigationView;

    ListView listView;
    TourAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.tour_drawer_layout);
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
                        Toast.makeText(TourActivity.this, "Map Click", Toast.LENGTH_SHORT).show();
                        Intent mapIntent = new Intent(TourActivity.this, ShowMap_Activity.class);
                        startActivity(mapIntent);
                        finish();
                        break;

                    case R.id.navigation_road:
                        Toast.makeText(TourActivity.this, "Road Click", Toast.LENGTH_SHORT).show();
                        Intent roadIntent = new Intent(TourActivity.this, FindWay_Activity.class);
                        startActivity(roadIntent);
                        finish();
                        break;
                    case R.id.navigation_sisul:
                        Toast.makeText(TourActivity.this, "Road Click", Toast.LENGTH_SHORT).show();
                        Intent sisulIntent = new Intent(TourActivity.this, AroundArea_Activity.class);
                        startActivity(sisulIntent);
                        finish();
                        break;
                    case R.id.navigation_event:
                        Toast.makeText(TourActivity.this, "Event Click", Toast.LENGTH_SHORT).show();
                        Intent eventIntent = new Intent(TourActivity.this, EventActivity.class);
                        startActivity(eventIntent);
                        finish();
                        break;

                }
                return true;
            }
        });

        listView = (ListView) findViewById(R.id.listview2);
        adapter2 = new TourAdapter(TourActivity.this, R.layout.tour_item, new ArrayList<Tour>());
        listView.setAdapter(adapter2);

        addData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tour item =adapter2.getItem(position);

                switch (position) {
                    case 0:
                        Intent course1 = new Intent(TourActivity.this, TourCourse1.class);
                        startActivity(course1);
                        finish();
                        break;
                    case 1:
                        Intent course2 = new Intent(TourActivity.this, TourCourse2.class);
                        startActivity(course2);
                        finish();
                        break;
                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
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

    class TourAdapter extends ArrayAdapter<Tour> {
        int resource;

        public TourAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Tour> objects) {
            super(context, resource, objects);
            this.resource = resource;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view=convertView;

            TourHolder holder;

            if(view==null){
                LayoutInflater inflater=getLayoutInflater();

                view = inflater.inflate(this.resource,null);

                holder=new TourHolder();
                holder.imageView=(ImageView)view.findViewById(R.id.imageView2);
                holder.textView=(TextView)view.findViewById(R.id.textView6);

                view.setTag(holder);
            }
            final Tour item=getItem(position);
            if(item!=null){
                holder=(TourHolder)view.getTag();

                holder.imageView.setImageResource(item.image);
                holder.textView.setText(item.name);
            }
            return view;
        }
    }

    void addData(){
        Tour around10=new Tour();
        around10.name="벚꽃 코스";
        around10.image=R.drawable.course1;
        adapter2.add(around10);

        Tour around11=new Tour();
        around11.name="학교구경코스";
        around11.image=R.drawable.course2;
        adapter2.add(around11);

    }

}