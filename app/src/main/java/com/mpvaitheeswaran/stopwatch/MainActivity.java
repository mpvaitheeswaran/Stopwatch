package com.mpvaitheeswaran.stopwatch;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    int flagIncrement=0;
    String flag="";
    //Toolbar class is using for create the custom ActionBar(AppBar) ;
    Toolbar appBar;
    //Create the static objects for accessing in the other classes;
    public static TextView tvDisplay;
    public static TextView tvMilliSec;
    public TextView tvFlag;
    ScrollView svFlags;
    ImageView ivStart,ivPause,ivStop,ivFlag;
    //create object for the StopWatch class to access the methods ;
    StopWatch stopWatch=new StopWatch(0,false,0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appBar=(Toolbar)findViewById(R.id.appBar);
        setSupportActionBar(appBar);

        tvDisplay=findViewById(R.id.tvDisplay);
        tvMilliSec=findViewById(R.id.tvMilliSec);
        tvFlag=findViewById(R.id.tvFlag);

        ivStart=findViewById(R.id.ivStart);
        ivPause=findViewById(R.id.ivPause);
        ivStop=findViewById(R.id.ivStop);
        ivFlag=findViewById(R.id.ivFlag);
        svFlags=findViewById(R.id.svFlags);
        //this method is start the another tread using for  increasing milli second 0-100;
        stopWatch.startMilliSec();
        //This method start the  tread using for increasing time;
        stopWatch.startStopWatch();
        ivPause.setVisibility(View.INVISIBLE);
        ivStop.setVisibility(View.GONE);
        ivFlag.setVisibility(View.INVISIBLE);
        tvFlag.setVisibility(View.INVISIBLE);
        ivStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopWatch.setRun(true);
                ivStart.setVisibility(View.INVISIBLE);
                ivPause.setVisibility(View.VISIBLE);
                ivFlag.setVisibility(View.VISIBLE);
                ivStop.setVisibility(View.INVISIBLE);
            }
        });
        ivPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopWatch.setRun(false);
                ivPause.setVisibility(View.INVISIBLE);
                ivFlag.setVisibility(View.INVISIBLE);
                ivStart.setVisibility(View.VISIBLE);
                ivStop.setVisibility(View.VISIBLE);
            }
        });
        ivStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopWatch.setRun(false);
                stopWatch.setSeconds(0);
                stopWatch.setMilliSec(0);
                flag="";
                flagIncrement=0;
                tvFlag.setVisibility(View.INVISIBLE);
                ivPause.setVisibility(View.INVISIBLE);
                ivStop.setVisibility(View.GONE);
                ivFlag.setVisibility(View.INVISIBLE);
            }
        });
        ivFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvFlag.setVisibility(View.VISIBLE);
                flagIncrement++;
                flag +=flagIncrement+".\t\t\t"+tvDisplay.getText().toString()+tvMilliSec.getText().toString()+"\n\n\n";
                tvFlag.setText(flag);
                //getBottom() method is did't working correctly so, i create the own formula it was working correct.
                int y=flagIncrement*flagIncrement*flagIncrement;
                svFlags.scrollTo(0,y);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_timer:
                Intent intent=new Intent(MainActivity.this,TimerActivity.class);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
