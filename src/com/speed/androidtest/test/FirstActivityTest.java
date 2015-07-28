package com.speed.androidtest.test;

import com.speed.androidtest.FirstActivity;
import com.speed.androidtest.R;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class FirstActivityTest extends ActivityInstrumentationTestCase2<FirstActivity> {

	private FirstActivity mFirstActivity;
	private TextView mFirstTestTextView;
	
	public FirstActivityTest() {
		super(FirstActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mFirstActivity = getActivity();
		mFirstTestTextView = (TextView) mFirstActivity.findViewById(R.id.first_test_textview);
	}
	
	public void testPreconditions() {
		assertNotNull("mFirstTestActivity is null", mFirstActivity);
        assertNotNull("mFirstTestText is null", mFirstTestTextView);
	}
	
	/*public void testFirstTestTextView_labelText() {
		final String expected = mFirstActivity.getString(R.string.hello_world);
        final String actual = mFirstTestTextView.getText().toString();
        assertEquals("mFirstTestText contains wrong text", expected, actual);
	}*/

}
