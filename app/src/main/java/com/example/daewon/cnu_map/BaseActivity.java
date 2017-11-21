package com.example.daewon.cnu_map;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = getWindow().getDecorView();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if( view != null) {
                //23 버젼 이상일 때 상태바 하얀 색상에 회색 아이콘 색상을 설정
                view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                getWindow().setStatusBarColor(Color.parseColor("#f2f2f2"));
            }
        } else if( Build.VERSION.SDK_INT >= 21) {
            //21 버젼 이상일 때
            getWindow().setStatusBarColor(Color.BLACK);
        }
    }
}
