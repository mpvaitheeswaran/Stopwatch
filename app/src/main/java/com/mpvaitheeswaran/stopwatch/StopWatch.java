package com.mpvaitheeswaran.stopwatch;

import android.annotation.SuppressLint;
import android.os.Handler;

import java.util.Locale;

public class StopWatch {
    private int milliSec = 0;
    private boolean run;
    private int seconds = 0;

    //getters and setters
    public int getMilliSec() {
        return milliSec;
    }

    public void setMilliSec(int milliSec) {
        this.milliSec = milliSec;
    }

    public boolean isRun() {
        return run;
    }

    void setRun(boolean run) {
        this.run = run;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }


    // Time increasing process method
    void startStopWatch() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (run) {
                    seconds++;
                }
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);
                MainActivity.tvDisplay.setText(time);
                handler.postDelayed(this, 1000);
            }
        });

    }
    // Milli second  increasing process method
    void startMilliSec() {
        final Handler handler1 = new Handler();
        handler1.post(new Runnable() {
            @Override
            public void run() {

                if (run) {
                    milliSec++;
                }
                if (milliSec == 100) {
                    milliSec = 0;
                }
                String time = ":" + String.format(Locale.getDefault(), "%02d", milliSec);
                MainActivity.tvMilliSec.setText(time);
                handler1.postDelayed(this, 10);
            }
        });
    }
}
