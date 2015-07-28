package com.speed.androidtest.test;

import com.speed.androidtest.R;
import com.speed.androidtest.SecondTestUIActivity;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

public class SecondTestUIActivityTest extends ActivityInstrumentationTestCase2<SecondTestUIActivity> {

	private SecondTestUIActivity mSecondTestUIActivity;
	private Button mClickMeButton;
	
	public SecondTestUIActivityTest() {
		super(SecondTestUIActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setActivityInitialTouchMode(true);
		mSecondTestUIActivity = getActivity();
		mClickMeButton = (Button) mSecondTestUIActivity.findViewById(R.id.second_test_ui_btn);
	}
	
	@MediumTest
	public void testPreconditions() {
		assertNotNull("mFirstTestActivity is null", mSecondTestUIActivity);
        assertNotNull("mFirstTestText is null", mClickMeButton);
	}
	
	@MediumTest
	public void testClickMeButton_layout() {
		View decorView = mSecondTestUIActivity.getWindow().getDecorView();
		ViewAsserts.assertOnScreen(decorView, mClickMeButton);
		ViewGroup.LayoutParams layoutParams = mClickMeButton.getLayoutParams();
        assertNotNull(layoutParams);
        assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
        assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	}
	
	@MediumTest
	public void testClickMeButton_click() {
		//TouchUtils.clickView(this, mClickMeButton);
	}

}
