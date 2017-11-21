package com.example.daewon.cnu_map;

import android.os.Bundle;

import com.github.chrisbanes.photoview.PhotoView;

public class dongmun_station extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dongmun_station);

        PhotoView photoView = (PhotoView) findViewById(R.id.dongmun);
        photoView.setImageResource(R.drawable.dongmun);
    }
}
