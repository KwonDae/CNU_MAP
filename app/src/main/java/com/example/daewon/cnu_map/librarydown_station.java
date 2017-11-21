package com.example.daewon.cnu_map;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.chrisbanes.photoview.PhotoView;

public class librarydown_station extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_down);

        PhotoView photoView = (PhotoView) findViewById(R.id.librarydown);
        photoView.setImageResource(R.drawable.librarydown);
    }
}
