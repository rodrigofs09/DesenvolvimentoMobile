package com.example.victo.acorde.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.victo.acorde.Main.MainActivity;
import com.example.victo.acorde.R;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Actions to do after 2 seconds
                Intent abreApp = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(abreApp);
                finish();
            }
        }, 2000);
    }
}
