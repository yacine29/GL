package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Activity_Promo extends AppCompatActivity implements Dialog_AjoutePromo.Dialog_AddPromoListener {

    private ImageView btn_AddPromo_ActivityPromo;
    private ImageView btn_DeletePromo_ActivityPromo;
    private LinearLayout vb_ContentPromo_ActivityPromo;
    private Data data;
    private Dialog_AjoutePromo dialogADD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);
        btn_AddPromo_ActivityPromo = findViewById(R.id.btn_AddPromo_ActivityPromo);
        btn_DeletePromo_ActivityPromo = findViewById(R.id.btn_DeletePromo_ActivityPromo);
        vb_ContentPromo_ActivityPromo = findViewById(R.id.vb_ContentPromo_ActivityPromo);
        data=DataHolder.getInstance().getMyData();
        btn_AddPromo_ActivityPromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogADD = new Dialog_AjoutePromo();
                dialogADD.setCancelable(false);
                dialogADD.show(Activity_Promo.this.getFragmentManager(),"Add a Promo");

            }
        });

    }

    @Override
    public void onDataReceived_AddPromo(Data data) {
        this.data=data;
        DataHolder.getInstance().setMyData(data);
        SystemSaveLoad systemSaveLoad = new SystemSaveLoad(getBaseContext());
        systemSaveLoad.save_Data(data);
    }
}