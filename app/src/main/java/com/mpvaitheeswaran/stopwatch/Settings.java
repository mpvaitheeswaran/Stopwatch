package com.mpvaitheeswaran.stopwatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

   public static Switch enableDarkMode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        enableDarkMode=findViewById(R.id.enableDarkMode);
        SharedPreferences sharedPreferences=getSharedPreferences(MainActivity.MY_SHARED_PREF_FILE_NAME,MODE_PRIVATE);
        boolean isDarkMode=sharedPreferences.getBoolean("mode",false);
        if (isDarkMode){
            Settings.enableDarkMode.setChecked(true);
           // AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        }else {
            Settings.enableDarkMode.setChecked(false);
            //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        enableDarkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor =getSharedPreferences(MainActivity.MY_SHARED_PREF_FILE_NAME,MODE_PRIVATE).edit();
                if (isChecked){
                    editor.putBoolean("mode",true);
                    editor.apply();
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else {
                    editor.putBoolean("mode",false);
                    editor.apply();
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }
}
