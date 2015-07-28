package com.speed.androidtest;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondTestUIActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second_test_ui);
		Button clickMeButton = (Button) findViewById(R.id.second_test_ui_btn);
        clickMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondTestUIActivity.this, "点击了button", Toast.LENGTH_SHORT).show();
            }
        });
	}
	
}
