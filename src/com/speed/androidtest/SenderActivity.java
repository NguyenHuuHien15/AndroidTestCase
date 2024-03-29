package com.speed.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SenderActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);
        final Button sendMessageButton = (Button) findViewById(R.id.send_message_button);
        final EditText messageInputEditText = (EditText) findViewById(R.id.message_input_edit_text);
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (messageInputEditText != null) {
                    final CharSequence message = messageInputEditText.getText();
                    startActivity(ReceiverActivity.makeIntent(SenderActivity.this, message));
                }
            }
        });
    }
}
