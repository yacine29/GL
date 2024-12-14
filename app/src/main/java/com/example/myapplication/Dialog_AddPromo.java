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

public class Dialog_AddPromo extends DialogFragment {
    private TextInputEditText inp_NameClass_Promo;private TextInputEditText inp_Speciality_Promo;private TextInputEditText inp_Level_Promo;
    private Button btn_Cancel_Promo, btn_Add_Promo;
    private View view;
    private Context context;
    private Dialog_AddPromoListener listener;
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
        inp_NameClass_Promo =view.findViewById(R.id.inp_NameClass_Promo);
        inp_Speciality_Promo =view.findViewById(R.id.inp_Speciality_Promo);
        inp_Level_Promo =view.findViewById(R.id.inp_Level_Promo);
        btn_Cancel_Promo =view.findViewById(R.id.btn_Cancel_Warning);
        btn_Add_Promo =view.findViewById(R.id.btn_Delete_Warning);
        btn_Cancel_Promo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        btn_Add_Promo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!inp_Speciality_Promo.getText().toString().isEmpty()&&!inp_NameClass_Promo.getText().toString().isEmpty()&&!inp_Level_Promo.getText().toString().isEmpty()&& inp_Speciality_Promo.getText().toString().length()>1&&inp_NameClass_Promo.getText().toString().length()>1){
                    int currentYear = Year.now().getValue();
                    Promo promo=new Promo(inp_NameClass_Promo.getText().toString(),inp_Speciality_Promo.getText().toString(),inp_Level_Promo.getText().toString(),currentYear);
                    listener.onDataReceived_AddPromo(promo);
                    dismiss();
                }
            }
        });
        return view;
    };
    public interface Dialog_AddPromoListener {
        void onDataReceived_AddPromo(Promo promo);
    }

}
