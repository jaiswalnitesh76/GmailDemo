package com.example.gmaildemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.gmaildemo.R;

public class InboxActivity extends AppCompatActivity {
    private EditText recipient;
    private EditText subject;
    private EditText body;
    private ImageButton sendBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        recipient = (EditText) findViewById(R.id.recipient);
        subject = (EditText) findViewById(R.id.subject);
        body = (EditText) findViewById(R.id.body);

        sendBtn = (ImageButton) findViewById(R.id.sendEmail);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendEmail();
                // after sending the email, clear the fields
                recipient.setText("");
                subject.setText("");
                body.setText("");
            }
        });

    }
    protected void sendEmail() {

        String[] recipients = {recipient.getText().toString()};
        Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        // prompts email clients only
        email.setType("message/rfc822");

        email.putExtra(Intent.EXTRA_EMAIL, recipients);
        email.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
        email.putExtra(Intent.EXTRA_TEXT, body.getText().toString());

        try {
            // the user can choose the email client
            startActivity(Intent.createChooser(email, "Choose an email client from..."));

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(InboxActivity.this, "No email client installed.", Toast.LENGTH_LONG).show();
        }
    }
    }