package com.example.templateui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class ProgressCheck extends AppCompatActivity {

    ProgressBar progressBar;
    Button doneButton;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_progress_check);

        prog();


    }

    public void prog(){
        progressBar = (ProgressBar) findViewById(R.id.progress_check);
        final Timer timer = new Timer();


        TimerTask timerTask = new TimerTask() {
            @Override


            public void run() {
                counter++;
                progressBar.setProgress(counter);

                if(counter==100){
                    timer.cancel();
                    returnMain();
                }
            }
        };


        timer.schedule(timerTask, 0, 100);

    }

    public void returnMain(){
        Intent intent = new Intent(ProgressCheck.this, MainActivity.class);
        startActivity(intent);
    }

}