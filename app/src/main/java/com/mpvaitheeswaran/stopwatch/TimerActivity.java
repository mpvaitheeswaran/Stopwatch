package com.mpvaitheeswaran.stopwatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TimerActivity extends AppCompatActivity {
    Toolbar appBar;
    static EditText etHours,etMinutes,etSeconds;
    static TextView tvHours,tvMinutes,tvSeconds;
    static ImageView ivStart,ivPause,ivStop;
    static Button btnTimerStart;
    public static TextView tvTimer;
    int hours,minutes,seconds;
    public  int totalSeconds;
    Timer timer=new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        appBar = (Toolbar) findViewById(R.id.appBar);
        appBar.setTitle("Timer");
        setSupportActionBar(appBar);
        btnTimerStart=findViewById(R.id.btnTimerStart);
        etHours=findViewById(R.id.etHours);
        etMinutes=findViewById(R.id.etMinutes);
        etSeconds=findViewById(R.id.etSeconds);
        ivStart=findViewById(R.id.ivStart);
        ivPause=findViewById(R.id.ivPause);
        ivStop=findViewById(R.id.ivStop);
        tvTimer=findViewById(R.id.tvTimer);
        tvHours=findViewById(R.id.tvHours);
        tvMinutes=findViewById(R.id.tvMinutes);
        tvSeconds=findViewById(R.id.tvSeconds);

        ivStart.setVisibility(View.GONE);
        ivPause.setVisibility(View.GONE);
        ivStop.setVisibility(View.GONE);
        tvTimer.setVisibility(View.GONE);

        timer.startTimer();

        btnTimerStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strHours,strMinutes,strSeconds;

                 if (!(etHours.getText().toString().isEmpty()&&
                        etSeconds.getText().toString().isEmpty()&&
                        etMinutes.getText().toString().isEmpty())){
                    tvTimer.setVisibility(View.VISIBLE);
                    etHours.setVisibility(View.GONE);
                    etMinutes.setVisibility(View.GONE);
                    etSeconds.setVisibility(View.INVISIBLE);
                    btnTimerStart.setVisibility(View.INVISIBLE);
                    ivStart.setVisibility(View.INVISIBLE);
                    ivPause.setVisibility(View.VISIBLE);
                    tvHours.setVisibility(View.INVISIBLE);
                    tvMinutes.setVisibility(View.INVISIBLE);
                    tvSeconds.setVisibility(View.INVISIBLE);
                    strHours = etHours.getText().toString().trim();
                    strMinutes = etMinutes.getText().toString().trim();
                    strSeconds = etSeconds.getText().toString().trim();
                    hours=Integer.parseInt(strHours);
                    minutes=Integer.parseInt(strMinutes);
                    seconds=Integer.parseInt(strSeconds);
                    timer.setSeconds(totalSeconds);
                    timer.setRun(true);
                    

                }else {
                    Toast.makeText(TimerActivity.this, "Please.. fill the any one field", Toast.LENGTH_SHORT).show();
                }

                int totalHours=hours*60;
                int totalMinutes=totalHours+minutes;
                totalSeconds=(totalMinutes*60)+seconds;


            }
        });
        ivStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ivStart.setVisibility(View.INVISIBLE);
                ivPause.setVisibility(View.VISIBLE);
                ivStop.setVisibility(View.VISIBLE);
                //timer.setSeconds(totalSeconds);
                timer.setRun(true);
            }
        });
        ivPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // stopWatch.setRun(false);
                ivPause.setVisibility(View.INVISIBLE);
                ivStart.setVisibility(View.VISIBLE);
                ivStop.setVisibility(View.VISIBLE);
                timer.setRun(false);

            }
        });
        ivStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ivStart.setVisibility(View.GONE);
                ivPause.setVisibility(View.GONE);
                ivStop.setVisibility(View.GONE);
                etHours.setVisibility(View.VISIBLE);
                etMinutes.setVisibility(View.VISIBLE);
                etSeconds.setVisibility(View.VISIBLE);
                btnTimerStart.setVisibility(View.VISIBLE);
                tvTimer.setVisibility(View.INVISIBLE);
                tvHours.setVisibility(View.VISIBLE);
                tvMinutes.setVisibility(View.VISIBLE);
                tvSeconds.setVisibility(View.VISIBLE);
                timer.setRun(false);
                totalSeconds=0;

            }
        });
    }
    static void timerFinished(){
        ivStart.setVisibility(View.INVISIBLE);
        ivPause.setVisibility(View.INVISIBLE);
        ivStop.setVisibility(View.INVISIBLE );
        etHours.setVisibility(View.VISIBLE);
        etMinutes.setVisibility(View.VISIBLE);
        etSeconds.setVisibility(View.VISIBLE);
        btnTimerStart.setVisibility(View.VISIBLE);

        tvTimer.setVisibility(View.INVISIBLE);
        tvHours.setVisibility(View.VISIBLE);
        tvMinutes.setVisibility(View.VISIBLE);
        tvSeconds.setVisibility(View.VISIBLE);

    }



}
