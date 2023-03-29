package com.example.stopwatch;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private long PauseOffSet = 0;
    private boolean isPlaying = false;
    private GifImageView run_gif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = findViewById(R.id.chronometer);
        ToggleButton toggleButton = findViewById(R.id.Toggle);
        Button reset_btn = findViewById(R.id.reset_btn);
        run_gif = findViewById(R.id.header);
        toggleButton.setText(null);
        toggleButton.setTextOn(null);
        toggleButton.setTextOff(null);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean btn_status) {

                if(btn_status){
                    chronometer.setBase(SystemClock.elapsedRealtime() - PauseOffSet);
                    chronometer.start();
                    isPlaying = true;
                    run_gif.setVisibility(View.VISIBLE);
                    ((GifDrawable)run_gif.getDrawable()).start();
                }else{
                    chronometer.stop();
                    PauseOffSet = SystemClock.elapsedRealtime()- chronometer.getBase();
                    isPlaying = false;
                    ((GifDrawable)run_gif.getDrawable()).pause();
                }
                if (isPlaying){
                    Toast.makeText(MainActivity.this, "Started!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Paused!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlaying){
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    PauseOffSet = 0;
                    chronometer.start();
                    isPlaying = true;
                    run_gif.setVisibility(View.VISIBLE);
                    ((GifDrawable)run_gif.getDrawable()).reset();
                    Toast.makeText(MainActivity.this, "Reset!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}