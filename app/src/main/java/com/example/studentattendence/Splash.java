package com.example.studentattendence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread background = new Thread() {
            public void run() {
                try {

                    sleep(2 * 1000);
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);


                    finish();
                } catch (Exception e) {
                }
            }
        };

        background.start();
    }

}
