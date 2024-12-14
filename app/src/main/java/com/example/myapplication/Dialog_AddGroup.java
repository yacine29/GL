package com.example.myapplication;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Dialog_AddGroup extends DialogFragment {
    private Button btn_Add_AddGroup;
    private TextView out_Name_AddGroup;
    private CheckBox cbx_TD_AddGroup,cbx_TP_AddGroup;
    private View view;
    private Context context;
    private Dialog_AddGroupListener listener;
    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        this.context=context;
        try {
            listener = (Dialog_AddGroupListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement DialogListener in Activity_Promo");
        }
    }
        @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_add_group,container,false);
        btn_Add_AddGroup =view.findViewById(R.id.btn_Add_AddGroup);
        cbx_TD_AddGroup=view.findViewById(R.id.cbx_TD_AddGroup);
        cbx_TP_AddGroup=view.findViewById(R.id.cbx_TP_AddGroup);
        out_Name_AddGroup=view.findViewById(R.id.out_Name_AddGroup);
        out_Name_AddGroup.setText("Select Type Group: "+String.valueOf(DataHolder.getInstance().getNewGroupes().get(0).getNum()));
        cbx_TD_AddGroup.setChecked(true);


        btn_Add_AddGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbx_TD_AddGroup.isChecked()||cbx_TP_AddGroup.isChecked()){
                    if (cbx_TD_AddGroup.isChecked()&&!cbx_TP_AddGroup.isChecked()){
                        DataHolder.getInstance().getNewGroupes().get(0).setIndexType(0);
                    }else if (!cbx_TD_AddGroup.isChecked()&&cbx_TP_AddGroup.isChecked()){
                        DataHolder.getInstance().getNewGroupes().get(0).setIndexType(1);
                    }else {
                        DataHolder.getInstance().getNewGroupes().get(0).setIndexType(2);
                    }
                    DataHolder.getInstance().setTargetGroup(DataHolder.getInstance().getNewGroupes().get(0));
                    dismiss();
                    DataHolder.getInstance().getNewGroupes().remove(0);
                    listener.addGroup(DataHolder.getInstance().getTargetGroup());
                }
            }
        });
        return view;
    };
    public interface Dialog_AddGroupListener {
        void addGroup(Group group);
    }


}
