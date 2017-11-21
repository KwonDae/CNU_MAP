package com.example.daewon.cnu_map;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.chrisbanes.photoview.PhotoView;

public class dormitary_station extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dormitary);

        PhotoView photoView = (PhotoView) findViewById(R.id.dormitary);
        photoView.setImageResource(R.drawable.dormitary);
    }
}
