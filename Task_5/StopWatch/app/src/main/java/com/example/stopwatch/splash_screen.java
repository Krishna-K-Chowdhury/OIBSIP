package com.example.stopwatch;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);


        new Handler().postDelayed(new Runnable() {

            public void run() {

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
                Toast.makeText(splash_screen.this, "Welcome!", Toast.LENGTH_SHORT).show();

            }
        }, 5000);
    }

}