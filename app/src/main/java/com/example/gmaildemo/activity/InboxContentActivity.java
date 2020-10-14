package com.example.gmaildemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.gmaildemo.R;

public class InboxContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox_content);
        getIncomingIntent();

    }
    private  void getIncomingIntent(){
        if(getIntent().hasExtra("maasage")){
            String messages = getIntent().getStringExtra("maasage");
            setDetails(messages);
        }
    }
    private void setDetails(String messages){
        TextView msg = findViewById(R.id.msg);
        msg.setText(messages);
    }
}