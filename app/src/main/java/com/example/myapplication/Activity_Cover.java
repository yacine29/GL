package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Activity_Cover extends AppCompatActivity {
    private SystemSaveLoad systemSaveLoad ;
    MyComponent.TimerThread timerThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);
        MyComponent.Mode.changeBarStatusColor(this,R.color.white,false);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
        timerThread= new MyComponent.TimerThread(getBaseContext());
        systemSaveLoad = new SystemSaveLoad(getBaseContext());
        if (systemSaveLoad.load_Data()!=null){
            Intent intent = new Intent(getBaseContext(),Activity_Promo.class);
            DataHolder.getInstance().setMyData(systemSaveLoad.load_Data());
            timerThread.startTimer(3, new Runnable() {
                @Override
                public void run() {
                    startActivity(intent);
                    finish();
                }
            });

        }else {
            Intent intent = new Intent(getBaseContext(),Activity_Promo.class);
            DataHolder.getInstance().setMyData(new Data());
            timerThread.startTimer(3, new Runnable() {
                @Override
                public void run() {
                    startActivity(intent);
                    finish();
                }
            });
        }
    }
}