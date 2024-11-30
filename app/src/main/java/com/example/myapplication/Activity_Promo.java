package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.apache.commons.lang3.ObjectUtils;

public class Activity_Promo extends AppCompatActivity {

    ImageView btn_AddPromo_ActivityPromo;
    ImageView btn_DeletePromo_ActivityPromo;
    LinearLayout vb_ContentPromo_ActivityPromo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);
        btn_AddPromo_ActivityPromo = findViewById(R.id.btn_AddPromo_ActivityPromo);
        btn_DeletePromo_ActivityPromo = findViewById(R.id.btn_DeletePromo_ActivityPromo);
        vb_ContentPromo_ActivityPromo = findViewById(R.id.vb_ContentPromo_ActivityPromo);
        btn_AddPromo_ActivityPromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getIntent().getParcelableExtra("Data")!= null){
                    Toast.makeText(getBaseContext(),"Data Availble",Toast.LENGTH_SHORT).show();
                    Parcelable data =  getIntent().getParcelableExtra("Data");
                    Data promo = (Data) data;
                }else {
                    Toast.makeText(getBaseContext(),"Data not Availble",Toast.LENGTH_SHORT).show();
                }
                Dialog_AjoutePromo dialogADD = new Dialog_AjoutePromo();
                dialogADD.setCancelable(false);
                dialogADD.show(Activity_Promo.this.getFragmentManager(),"Add a Promo");

            }
        });
    }
}