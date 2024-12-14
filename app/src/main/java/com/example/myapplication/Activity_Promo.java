package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Activity_Promo extends AppCompatActivity implements Dialog_AddPromo.Dialog_AddPromoListener {
    private ImageView btn_AddPromo_ActivityPromo;
    private LinearLayout vb_ContentPromo_ActivityPromo;
    private Data data;
    private Dialog_AddPromo dialogADD;
    private Dialog_WarningDelete warningDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);
        btn_AddPromo_ActivityPromo = findViewById(R.id.btn_AddPromo_ActivityPromo);
        vb_ContentPromo_ActivityPromo = findViewById(R.id.vb_ContentPromo_ActivityPromo);
        data = DataHolder.getInstance().getMyData();
        {
            for (Promo p : data.getPromos()) {
                Content_Promo content_promo = new Content_Promo(this, p, new Content_Promo.EventContentListener() {
                    @Override
                    public void sendActivity() {
                        int index = data.getPromos().indexOf(p);
                        Intent intent = new Intent(getBaseContext(), Activity_AllGroups.class);
                        intent.putExtra("IndexPromo",index);
                        startActivity(intent);
                    }

                    @Override
                    public void onDeleting(Promo promo,View content) {
                        DataHolder.getInstance().setTargetPromo(promo);
                        warningDelete = new Dialog_WarningDelete();
                        warningDelete.setCancelable(false);
                        warningDelete.show(Activity_Promo.this.getFragmentManager(),"Delete a Promo");
                        DataHolder.getInstance().setTargetContentLayout(vb_ContentPromo_ActivityPromo);
                        DataHolder.getInstance().setTargetContent(content);
                        DataHolder.getInstance().setTargetPromo(promo);
                    }
                });
                    vb_ContentPromo_ActivityPromo.addView(content_promo.getContent());

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
                public void sendActivity() {
                   int index = data.getPromos().indexOf(promo);
                    Intent intent = new Intent(getBaseContext(), Activity_AllGroups.class);
                    intent.putExtra("IndexPromo",index);
                    startActivity(intent);
                }
                @Override
                public void onDeleting(Promo content_Promo,View content) {
                    warningDelete = new Dialog_WarningDelete();
                    warningDelete.setCancelable(false);
                    warningDelete.show(Activity_Promo.this.getFragmentManager(),"Delete a Promo");
                    DataHolder.getInstance().setTargetContentLayout(vb_ContentPromo_ActivityPromo);
                    DataHolder.getInstance().setTargetContent(content);
                    DataHolder.getInstance().setTargetPromo(promo);
                }
            });
                vb_ContentPromo_ActivityPromo.addView(content_promo.getContent());

        }
    }


}