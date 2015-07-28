package com.speed.androidtest;

import com.speed.androidtest.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends Activity {

    public final static String EXTRAS_PAYLOAD_KEY
            = "com.speed.androidtest.EXTRAS_PAYLOAD_KEY";

    public static Intent makeIntent(Context context, String payload) {
        return new Intent(context, NextActivity.class).putExtra(EXTRAS_PAYLOAD_KEY, payload);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        final String stringPayload = getIntent().getStringExtra(EXTRAS_PAYLOAD_KEY);

        if (stringPayload != null) {
            ((TextView) findViewById(R.id.next_activity_info_text_view)).setText(stringPayload);
        }

    }
}
