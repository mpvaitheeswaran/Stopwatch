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

public class TimerActivity extends AppCompatActivity {
    Toolbar appBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        appBar = (Toolbar) findViewById(R.id.appBar);
        appBar.setTitle("Timer");
        setSupportActionBar(appBar);
    }




}
