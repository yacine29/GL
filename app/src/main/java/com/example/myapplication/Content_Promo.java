package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

public class Content_Promo {
    private View content;
    private Context context;
    private final int CONTENT_ID = R.layout.content_promo;
    private CardView pnl_Content_ContentPromo;
    private TextView inp_Year_ContentPromo, inp_Name_ContentPromo;
    private Promo promo ;

    public Promo getPromo() {
        return promo;
    }
    EventContentListener eventContentListener ;
    public View getContent() {
        return content;
    }


    public Content_Promo(Context context , Promo promo , EventContentListener eventContentListener){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.content = inflater.inflate(CONTENT_ID,null);
        this.context = context;
        this.eventContentListener = eventContentListener;
        this.pnl_Content_ContentPromo = content.findViewById(R.id.pnl_Content_ContentPromo);
        this.inp_Name_ContentPromo = content.findViewById(R.id.inp_Name_ContentPromo);
        this.inp_Year_ContentPromo = content.findViewById(R.id.inp_Year_ContentPromo);
        this.promo=promo;
        this.inp_Name_ContentPromo.setText(promo.getNom());
        this.inp_Year_ContentPromo.setText(String.valueOf(promo.getYear()));
        pnl_Content_ContentPromo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(context, "Long Click"+promo.getNom(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        pnl_Content_ContentPromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventContentListener.SendActivity();
            }
        });
    }
    public interface EventContentListener{
        public void SendActivity();
    }
}
