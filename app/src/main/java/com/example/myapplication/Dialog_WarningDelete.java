package com.example.myapplication;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Dialog_WarningDelete extends DialogFragment {
    private Button btn_Cancel_Warning, btn_Delete_Warning;
    private TextView out_NameContent_Warning;
    private View view;
    private Context context;
    @Override
    public void onAttach(Activity context) {

        super.onAttach(context);
        this.context=context;
        try {
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement DialogListener in Activity_Promo");
        }
    }
        @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_delete_warning,container,false);
        btn_Cancel_Warning =view.findViewById(R.id.btn_Cancel_Warning);
        btn_Delete_Warning =view.findViewById(R.id.btn_Delete_Warning);
        out_NameContent_Warning=view.findViewById(R.id.out_NameContent_Warning);
            if (context.getClass().equals(Activity_Promo.class)){
                out_NameContent_Warning.setText("Delete Promo");
            }else if(context.getClass().equals(Activity_AllGroups.class)){
                out_NameContent_Warning.setText("Delete Group");
            }
        btn_Cancel_Warning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        btn_Delete_Warning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getClass().equals(Activity_Promo.class)){
                    out_NameContent_Warning.setText("Delete Promo");
                    DataHolder.getInstance().getTargetContentLayout().removeView(DataHolder.getInstance().getTargetContent());
                    DataHolder.getInstance().getMyData().getPromos().remove(DataHolder.getInstance().getTargetPromo());
                    SystemSaveLoad systemSaveLoad = new SystemSaveLoad(context);
                    systemSaveLoad.save_Data(DataHolder.getInstance().getMyData());
                } else if (context.getClass().equals(Activity_AllGroups.class)) {
                    out_NameContent_Warning.setText("Delete Group");
                    DataHolder.getInstance().getTargetContentLayout().removeView(DataHolder.getInstance().getTargetContent());
                    DataHolder.getInstance().getTargetPromo().getGroupes().remove(DataHolder.getInstance().getTargetGroup());
                    SystemSaveLoad systemSaveLoad = new SystemSaveLoad(context);
                    systemSaveLoad.save_Data(DataHolder.getInstance().getMyData());
                }

                dismiss();
            }
        });
        return view;
    };
}
