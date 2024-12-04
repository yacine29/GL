package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Activity_Promo extends AppCompatActivity implements Dialog_AddPromo.Dialog_AddPromoListener {

    private ImageView btn_AddPromo_ActivityPromo;
    private ImageView btn_DeletePromo_ActivityPromo;
    private LinearLayout vb_ContentPromo1_ActivityPromo,vb_ContentPromo2_ActivityPromo;
    private Data data;
    private Dialog_AddPromo dialogADD;
    private static int switchVerticalContent=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_promo);
            btn_AddPromo_ActivityPromo = findViewById(R.id.btn_AddPromo_ActivityPromo);
            btn_DeletePromo_ActivityPromo = findViewById(R.id.btn_DeletePromo_ActivityPromo);
            vb_ContentPromo1_ActivityPromo = findViewById(R.id.vb_ContentPromo1_ActivityPromo);
            vb_ContentPromo2_ActivityPromo = findViewById(R.id.vb_ContentPromo2_ActivityPromo);
            data = DataHolder.getInstance().getMyData();
        {
            for (Promo p : data.getPromos()) {
                Content_Promo content_promo = new Content_Promo(this, p, new Content_Promo.EventContentListener() {
                    @Override
                    public void SendActivity() {
                        int index = data.getPromos().indexOf(p);
                        Intent intent = new Intent(getBaseContext(), Activity_Groups.class);
                        intent.putExtra("IndexPromo",index);
                        startActivity(intent);
                        finish();
                    }
                });
                if (switchVerticalContent == 0) {
                    vb_ContentPromo1_ActivityPromo.addView(content_promo.getContent());
                    switchVerticalContent = 1;
                } else if (switchVerticalContent == 1) {
                    vb_ContentPromo2_ActivityPromo.addView(content_promo.getContent());
                    switchVerticalContent = 0;
                }
            }
        }//Fetch Data And View in Contents
        btn_AddPromo_ActivityPromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                dialogADD = new Dialog_AddPromo();
                dialogADD.setCancelable(false);
                dialogADD.show(Activity_Promo.this.getFragmentManager(),"Add a Promo");
                }//Make Window AddPromo
            }
        });//Event Click To Add Promo

    }

    @Override
    public void onDataReceived_AddPromo(Promo promo) {
        this.data.addPromo(promo);
        {
        DataHolder.getInstance().setMyData(this.data);
        SystemSaveLoad systemSaveLoad = new SystemSaveLoad(getBaseContext());
        systemSaveLoad.save_Data(this.data);}//Save Data in SystemCache and Holder
        {
            Content_Promo content_promo = new Content_Promo(this, promo, new Content_Promo.EventContentListener() {
                @Override
                public void SendActivity() {
                   int index = data.getPromos().indexOf(promo);
                    Intent intent = new Intent(getBaseContext(), Activity_Groups.class);
                    intent.putExtra("IndexPromo",index);
                    startActivity(intent);
                    finish();
                }
            });
            if (switchVerticalContent == 0) {
                vb_ContentPromo1_ActivityPromo.addView(content_promo.getContent());
                switchVerticalContent = 1;
            } else if (switchVerticalContent == 1) {
                vb_ContentPromo2_ActivityPromo.addView(content_promo.getContent());
                switchVerticalContent = 0;
            }
        }//Add Promo View in Contents
    }
}