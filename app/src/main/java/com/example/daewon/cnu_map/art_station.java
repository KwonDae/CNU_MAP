package com.example.daewon.cnu_map;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.chrisbanes.photoview.PhotoView;

public class art_station extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_station);

        PhotoView photoView = (PhotoView) findViewById(R.id.art);
        photoView.setImageResource(R.drawable.art);
    }
}
