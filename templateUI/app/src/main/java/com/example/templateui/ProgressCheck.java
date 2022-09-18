package com.example.templateui;

import static com.example.templateui.R.drawable.default_rounded_button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

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