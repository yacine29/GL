package com.example.myapplication;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;

import java.time.Year;
import java.util.Random;

public class Dialog_AjoutePromo extends DialogFragment {
    private TextInputEditText inp_Name_Promo;
    private Button btn_Cancel_Promo, btn_Add_Promo;
    private View view;
    private Context context;
    private Data data ;
    private Dialog_AddPromoListener listener;
    private static String getRandomColorCode() {
        Random random = new Random();
        int color = random.nextInt(0xFFFFFF + 1);
        return String.format("#%06X", color);
    }
    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        this.context=context;
        try {
            listener = (Dialog_AddPromoListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement DialogListener in Activity_Promo");
        }
    }
        @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_add_promo,container,false);
        inp_Name_Promo=view.findViewById(R.id.inp_Nom_Promo);
        btn_Cancel_Promo =view.findViewById(R.id.btn_Cancel_Promo);
        btn_Add_Promo =view.findViewById(R.id.btn_Add_Promo);
        data=DataHolder.getInstance().getMyData();
        btn_Cancel_Promo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        btn_Add_Promo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!inp_Name_Promo.getText().toString().isEmpty()&&inp_Name_Promo.getText().toString().length()>1){
                    int currentYear = Year.now().getValue();
                    data.addPromo(new Promo(inp_Name_Promo.getText().toString(),currentYear,getRandomColorCode()));
                    listener.onDataReceived_AddPromo(data);
                    dismiss();
                }
            }
        });
        return view;
    };
    public interface Dialog_AddPromoListener {
        void onDataReceived_AddPromo(Data data);
    }

}
