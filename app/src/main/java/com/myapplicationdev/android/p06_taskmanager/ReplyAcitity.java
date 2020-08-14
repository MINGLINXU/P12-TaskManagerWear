package com.myapplicationdev.android.p06_taskmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.RemoteInput;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ReplyAcitity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_acitity);

        CharSequence reply = null;
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);
        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
        if (remoteInput != null){
            reply = remoteInput.getCharSequence("status");
        }

        if (reply != null){
            if(reply == "Completed" ){
                DBHelper db = new DBHelper(ReplyAcitity.this);
                db.deleteTask(id);
                db.close();


            }else {
                Toast.makeText(ReplyAcitity.this, "You have indicated: " + reply, Toast.LENGTH_SHORT).show();
            }

        }

    }
}