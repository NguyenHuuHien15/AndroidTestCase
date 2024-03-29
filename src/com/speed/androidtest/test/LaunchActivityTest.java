package com.speed.androidtest.test;

import com.speed.androidtest.LaunchActivity;
import com.speed.androidtest.NextActivity;
import com.speed.androidtest.R;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;

public class LaunchActivityTest extends ActivityUnitTestCase<LaunchActivity> {

    private Intent mLaunchIntent;

    public LaunchActivityTest() {
        super(LaunchActivity.class);
    }


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mLaunchIntent = new Intent(getInstrumentation().getTargetContext(),
                LaunchActivity.class);
    }

    @MediumTest
    public void testPreconditions() {
        startActivity(mLaunchIntent, null, null);
        final Button launchNextButton = (Button) getActivity().findViewById(R.id.launch_next_activity_button);

        assertNotNull("mLaunchActivity is null", getActivity());
        assertNotNull("mLaunchNextButton is null", launchNextButton);
    }


    @MediumTest
    public void testLaunchNextActivityButton_labelText() {
        startActivity(mLaunchIntent, null, null);
        final Button launchNextButton = (Button) getActivity().findViewById(R.id.launch_next_activity_button);

        final String expectedButtonText = getActivity().getString(R.string.label_launch_next);
        assertEquals("Unexpected button label text", expectedButtonText,
                launchNextButton.getText());
    }

    @MediumTest
    public void testNextActivityWasLaunchedWithIntent() {
        startActivity(mLaunchIntent, null, null);
        final Button launchNextButton = (Button) getActivity().findViewById(R.id.launch_next_activity_button);
        launchNextButton.performClick();

        final Intent launchIntent = getStartedActivityIntent();
        assertNotNull("Intent was null", launchIntent);
        assertTrue(isFinishCalled());


        final String payload = launchIntent.getStringExtra(NextActivity.EXTRAS_PAYLOAD_KEY);
        assertEquals("Payload is empty", LaunchActivity.STRING_PAYLOAD
                , payload);
    }
}