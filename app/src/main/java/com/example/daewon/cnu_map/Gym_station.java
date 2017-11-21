package com.example.daewon.cnu_map;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.chrisbanes.photoview.PhotoView;

public class Gym_station extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_station);

        PhotoView photoView = (PhotoView) findViewById(R.id.gym);
        photoView.setImageResource(R.drawable.gym);
    }
}
