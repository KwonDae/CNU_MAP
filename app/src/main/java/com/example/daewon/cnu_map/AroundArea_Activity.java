package com.example.daewon.cnu_map;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
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

public class AroundArea_Activity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigationView;

    ListView listView;
    AroundAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_around_area_);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.AroundArea_drawer_layout);
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
                        Toast.makeText(AroundArea_Activity.this, "Map Click", Toast.LENGTH_SHORT).show();
                        Intent mapIntent = new Intent(AroundArea_Activity.this, ShowMap_Activity.class);
                        startActivity(mapIntent);
                        finish();
                        break;

                    case R.id.navigation_road:
                        Toast.makeText(AroundArea_Activity.this, "Road Click", Toast.LENGTH_SHORT).show();
                        Intent roadIntent = new Intent(AroundArea_Activity.this, FindWay_Activity.class);
                        startActivity(roadIntent);
                        finish();
                        break;
                    case R.id.navigation_sisul:
                        Toast.makeText(AroundArea_Activity.this, "Road Click", Toast.LENGTH_SHORT).show();
                        Intent sisulIntent = new Intent(AroundArea_Activity.this, AroundArea_Activity.class);
                        startActivity(sisulIntent);
                        finish();
                        break;
                    case R.id.navigation_event:
                        Toast.makeText(AroundArea_Activity.this, "Event Click", Toast.LENGTH_SHORT).show();
                        Intent eventIntent = new Intent(AroundArea_Activity.this, EventActivity.class);
                        startActivity(eventIntent);
                        finish();
                        break;

                }
                return true;
            }
        });

        listView = (ListView) findViewById(R.id.listview);
        adapter = new AroundAdapter(AroundArea_Activity.this, R.layout.around_item, new ArrayList<Around>());
        listView.setAdapter(adapter);

        addData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Around item = adapter.getItem(position);

                switch (position) {
                    case 0:
                        String url0 = "daummaps://search?q=맛집&p=36.370082,127.346223";
                        Intent intent0 = new Intent(Intent.ACTION_VIEW, Uri.parse(url0));
                        startActivity(intent0);
                        break;
                    case 1:
                        String url1 = "daummaps://search?q=은행&p=36.370082,127.346223";
                        Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(url1));
                        startActivity(intent1);
                        break;
                    case 2:
                        String url2 = "daummaps://search?q=카페&p=36.370082,127.346223";
                        Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(url2));
                        startActivity(intent2);
                        break;
                    case 3:
                        String url3 = "daummaps://search?q=병원&p=36.370082,127.346223";
                        Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse(url3));
                        startActivity(intent3);
                        break;
                    case 4:
                        String url4 = "daummaps://search?q=서점&p=36.370082,127.346223";
                        Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse(url4));
                        startActivity(intent4);
                        break;
                    case 5:
                        String url5 = "daummaps://search?q=마트&p=36.370082,127.346223";
                        Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse(url5));
                        startActivity(intent5);
                        break;
                    case 6:
                        String url6 = "daummaps://search?q=약국&p=36.370082,127.346223";
                        Intent intent6 = new Intent(Intent.ACTION_VIEW, Uri.parse(url6));
                        startActivity(intent6);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class AroundAdapter extends ArrayAdapter<Around> {
        int resource;

        public AroundAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Around> objects) {
            super(context, resource, objects);
            this.resource = resource;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = convertView;

            AroundHolder holder;

            if (view == null) {
                LayoutInflater inflater = getLayoutInflater();

                view = inflater.inflate(this.resource, null);

                holder = new AroundHolder();
                holder.imageView = (ImageView) view.findViewById(R.id.imageView);
                holder.textView = (TextView) view.findViewById(R.id.textView5);

                view.setTag(holder);
            }
            final Around item = getItem(position);
            if (item != null) {
                holder = (AroundHolder) view.getTag();

                holder.imageView.setImageResource(item.image);
                holder.textView.setText(item.name);
            }
            return view;
        }
    }

    void addData() {
        Around around1 = new Around();
        around1.name = "맛집";
        around1.image = R.drawable.restaurant;
        adapter.add(around1);

        Around around2 = new Around();
        around2.name = "은행";
        around2.image = R.drawable.bank;
        adapter.add(around2);

        Around around3 = new Around();
        around3.name = "카페";
        around3.image = R.drawable.cafe;
        adapter.add(around3);

        Around around4 = new Around();
        around4.name = "병원";
        around4.image = R.drawable.hospital;
        adapter.add(around4);

        Around around5 = new Around();
        around5.name = "서점";
        around5.image = R.drawable.library;
        adapter.add(around5);

        Around around6 = new Around();
        around6.name = "마트";
        around6.image = R.drawable.mart;
        adapter.add(around6);

        Around around7 = new Around();
        around7.name = "약국";
        around7.image = R.drawable.pharmacy;
        adapter.add(around7);

        Around around8 = new Around();
        around8.name = "ATM";
        around8.image = R.drawable.atm;
        adapter.add(around8);
    }
}
