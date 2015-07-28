package com.speed.androidtest;

import com.speed.androidtest.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LaunchActivity extends Activity {

    public final static String STRING_PAYLOAD = "Started from LaunchActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_next);
        Button launchNextButton = (Button) findViewById(R.id.launch_next_activity_button);
        launchNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(NextActivity.makeIntent(LaunchActivity.this, STRING_PAYLOAD));
                finish();
            }
        });
    }
}
