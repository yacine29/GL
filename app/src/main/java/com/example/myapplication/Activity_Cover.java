package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

public class Activity_Cover extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);
        SystemSaveLoad systemSaveLoad = new SystemSaveLoad(getBaseContext());
        if (systemSaveLoad.load_Data()!=null){
            Toast.makeText(getBaseContext(),"Exist",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getBaseContext(),Activity_Promo.class);
            intent.putExtra("Data", (Parcelable) systemSaveLoad.load_Data());
            startActivity(intent);
        }else {
            Toast.makeText(getBaseContext(),"Not_Exist",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getBaseContext(),Activity_Promo.class);
            startActivity(intent);
        }
    }
}
