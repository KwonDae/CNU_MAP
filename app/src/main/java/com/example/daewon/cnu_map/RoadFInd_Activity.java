package com.example.daewon.cnu_map;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RoadFInd_Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_find_);

        Intent intent = getIntent();
        double latitude = intent.getDoubleExtra("latitude",0);
        double longitude = intent.getDoubleExtra("longitude",0);
        double latitude2 = intent.getDoubleExtra("latitude2",0);
        double longitude2= intent.getDoubleExtra("longitude2",0);

        String url="daummaps://route?sp="+latitude+","+longitude+"&ep="+latitude2+","+longitude2+"&by=FOOT";
        Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent2);

    }
}
