package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

public class Content_Group {
    private View content;
    private Context context;
    private final int CONTENT_ID = R.layout.content_group;
    private CardView pnl_Content_ContentGroup;
    private TextView out_TypeGroup_ContentGroup,out_NumGroup_ContentGroup, out_NumStudent_ContentGroup,out_NumSession_ContentGroup;
    private Group group;
    private int indexContent;
    private EventContentListener eventContentListener ;

    public View getContent() {
        return content;
    }

    public Group getGroupe() {
        return group;
    }

    public Content_Group(Context context , Group group, EventContentListener eventContentListener){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.content = inflater.inflate(CONTENT_ID,null);
        this.context = context;
        this.group = group;
        this.eventContentListener = eventContentListener;
        this.pnl_Content_ContentGroup = content.findViewById(R.id.pnl_Content_ContentGroup);
        this.out_NumGroup_ContentGroup = content.findViewById(R.id.out_NumGroup_ContentGroup);
        this.out_NumStudent_ContentGroup = content.findViewById(R.id.out_NumStudent_ContentGroup);
        this.out_NumSession_ContentGroup = content.findViewById(R.id.out_NumSession_ContentGroup);
        this.out_TypeGroup_ContentGroup= content.findViewById(R.id.out_TypeGroup_ContentGroup);
        out_NumGroup_ContentGroup.setText(out_NumGroup_ContentGroup.getText().toString()+ group.getNum()+"");
        out_NumStudent_ContentGroup.setText(out_NumStudent_ContentGroup.getText().toString()+ group.getStudents().toArray().length+"");
        out_NumSession_ContentGroup.setText(out_NumSession_ContentGroup.getText().toString()+ group.getSessions().toArray().length+"");
        if (group.getIndexType()==0){
            out_TypeGroup_ContentGroup.setText("TD");
        }else if (group.getIndexType()==1){
            out_TypeGroup_ContentGroup.setText("TP");
        }else {
            out_TypeGroup_ContentGroup.setText("TD/TP");
        }

        pnl_Content_ContentGroup.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                eventContentListener.onDeleting(getGroupe(),getContent(),indexContent);
                return false;
            }
        });
        pnl_Content_ContentGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventContentListener.sendActivity();
            }
        });
    }
    public interface EventContentListener{
        public void sendActivity();
        public void onDeleting(Group group, View content, int indexContent);
    }
}
