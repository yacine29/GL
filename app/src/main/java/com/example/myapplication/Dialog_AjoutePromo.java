package com.example.myapplication;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;

public class Dialog_AjoutePromo extends DialogFragment {
    TextInputEditText inp_Name_Promo;
    Button btn_Cancel_Promo, btn_Add_Promo;
    private View view;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_add_promo,container,false);
        inp_Name_Promo=view.findViewById(R.id.inp_Nom_Promo);
        btn_Cancel_Promo =view.findViewById(R.id.btn_Cancel_Promo);
        btn_Add_Promo =view.findViewById(R.id.btn_Add_Promo);
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
                    // Bachir Code Hnaya ki y7o6 l ism w yodrok add tzid promo fel vector Promo les color y kono random
                }
            }
        });
        return view;
    };

    @Override
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
    }
}
