package com.planetinnovative.notesapplication.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.planetinnovative.notesapplication.R;
import com.planetinnovative.notesapplication.app.Constant;

public class SplashScreenActivity extends AppCompatActivity {
    private boolean isLogin = false;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SharedPreferences preferences = getSharedPreferences(Constant.SP_DB_NAME, MODE_PRIVATE);
        String userLogin = preferences.getString(Constant.USERNAME, "NOVALUE");
        if (userLogin.equals("NOVALUE"))
            isLogin = false;
        else
            isLogin = true;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (isLogin) {
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                } else {
                    intent = new Intent(getApplicationContext(), LoginActivity.class);
                }
                startActivity(intent);
                finish();
            }
        };
        Handler handler = new Handler();
        handler.postDelayed(runnable, 2000);

    }
}
