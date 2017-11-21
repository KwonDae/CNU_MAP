package com.example.daewon.cnu_map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class IntroActivity  extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        startActivity(new Intent(IntroActivity.this, MainActivity.class));
        finish();
    }
}