package com.mpvaitheeswaran.stopwatch;

import android.os.Handler;

import java.util.Locale;

public class Timer {
    private boolean run;
    private int seconds = 0;
    public boolean isFinished;


    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    void startTimer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                if (run) {
                    seconds--;
                }
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);
                TimerActivity.tvTimer.setText(time);
                handler.postDelayed(this, 1000);
                if(secs<=0){
                    run=false;
                    TimerActivity.timerFinished();
                }
            }
        });

    }
}
