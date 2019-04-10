package com.example.quizpajak;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(getApplicationContext(), Home.class));
                finish();
            }
        }, 3000L);
    }
}
