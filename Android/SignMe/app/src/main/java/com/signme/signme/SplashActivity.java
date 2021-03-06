package com.signme.signme;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.signme.signme.activity.HomeActivity;

/**
 * Created by NooHeat on 26/09/2017.
 */

public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 1500;
    Intent nextActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String token = getSharedPreferences("test", MODE_PRIVATE).getString("signme-x-access-token", null);

                if (token != null) {
                    nextActivity = new Intent(getApplicationContext(), HomeActivity.class);

                } else {
                    nextActivity = new Intent(getApplicationContext(), LoginActivity.class);
                }

                startActivity(nextActivity);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
