package com.example.daewon.cnu_map;

import android.os.Bundle;

import com.github.chrisbanes.photoview.PhotoView;

public class gyeongsang_station extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyeongsang);

        PhotoView photoView = (PhotoView) findViewById(R.id.gyeongsang);
        photoView.setImageResource(R.drawable.gyeongsang);
    }
}
