package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.ColorRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class MyComponent {
    public static class TimerThread {
        Context context ;
        private Handler mHandler;
        private boolean mIsTimerRunning = false;
        private Runnable runnable;

        public TimerThread(Context context) {
            mHandler = new Handler(Looper.getMainLooper());
            this.context=context;
        }

        public void startTimer(int seconds ,Runnable run) {
            mIsTimerRunning = true;
            runnable=run;
            mHandler.postDelayed(runnable, seconds*1000); // 1000 milliseconds = 1 seconds
        }

        public void stopTimer() {
            mIsTimerRunning = false;
            mHandler.removeCallbacks(runnable);
        }

    }
    public static String localDate() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        return formattedDateTime;
    }
    public static LocalDateTime convertStringToDateTime(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateTimeString, formatter);
    }
    public static int generateRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
    public static class Mode{

        public static  int getMode(Context context){
            return context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        }

        public static void autoChangeBarStatusColor(Activity activity){
            int nightModeFlags = activity.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
            switch (nightModeFlags) {
                case Configuration.UI_MODE_NIGHT_YES:
                    changeBarStatusColor(activity,R.color.white,false);
                    activity.getWindow().setNavigationBarColor(activity.getResources().getColor(R.color.white));
                    break;
                case Configuration.UI_MODE_NIGHT_NO:
                    changeBarStatusColor(activity,R.color.white,false);
                    activity.getWindow().setNavigationBarColor(activity.getResources().getColor(R.color.white));
                    break;
                case Configuration.UI_MODE_NIGHT_UNDEFINED:

                    break;
            }
        }
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public static void changeBarStatusColor(Activity activity, @ColorRes int color, boolean isOpacity) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(activity.getApplicationContext(), color));
            View decorView = activity.getWindow().getDecorView();

            if (isOpacity) {
                decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            } else decorView.setSystemUiVisibility(0);
        }
        public static void changeMode(Activity activity,boolean isDark){
            if(isDark){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                autoChangeBarStatusColor(activity);
            }else{ AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);autoChangeBarStatusColor(activity);}

        }



    }


}
