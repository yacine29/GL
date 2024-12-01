package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

public class Activity_Cover extends AppCompatActivity {
    private SystemSaveLoad systemSaveLoad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);
        systemSaveLoad = new SystemSaveLoad(getBaseContext());
        if (systemSaveLoad.load_Data()!=null){
            Toast.makeText(getBaseContext(),"Exist",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getBaseContext(),Activity_Promo.class);
            DataHolder.getInstance().setMyData(systemSaveLoad.load_Data());
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(getBaseContext(),"Not_Exist",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getBaseContext(),Activity_Promo.class);
            DataHolder.getInstance().setMyData(new Data());
            startActivity(intent);
            finish();
        }
    }
}
