package com.speed.androidtest.test;

import com.speed.androidtest.R;
import com.speed.androidtest.ReceiverActivity;
import com.speed.androidtest.SenderActivity;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SenderActivityTest extends ActivityInstrumentationTestCase2<SenderActivity> {

    private static final int TIMEOUT_IN_MS = 5000;
    private static final String TEST_MESSAGE = "Hello";
    private SenderActivity mSenderActivity;

    public SenderActivityTest() {
        super(SenderActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(true);
        mSenderActivity = getActivity();
    }

    @MediumTest
    public void testPreconditions() {
        assertNotNull("mSenderActivity is null", mSenderActivity);
    }

    @MediumTest
    public void testSendMessageToReceiverActivity() {

        final Button sendToReceiverButton = (Button) mSenderActivity
                .findViewById(R.id.send_message_button);
        final EditText senderMessageEditText = (EditText) mSenderActivity
                .findViewById(R.id.message_input_edit_text);

        Instrumentation.ActivityMonitor receiverActivityMonitor = getInstrumentation()
                .addMonitor(ReceiverActivity.class.getName(), null, false);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                senderMessageEditText.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();

        getInstrumentation().sendStringSync(TEST_MESSAGE);
        getInstrumentation().waitForIdleSync();

        TouchUtils.clickView(this, sendToReceiverButton);

        ReceiverActivity receiverActivity = (ReceiverActivity) receiverActivityMonitor
                .waitForActivityWithTimeout(TIMEOUT_IN_MS);
        assertNotNull("ReceiverActivity is null", receiverActivity);
        assertEquals("Monitor for ReceiverActivity has not been called", 1,
                receiverActivityMonitor.getHits());
        assertEquals("Activity is of wrong type", ReceiverActivity.class,
                receiverActivity.getClass());

        final TextView receivedMessage = (TextView) receiverActivity
                .findViewById(R.id.received_message_text_view);
        assertNotNull(receivedMessage);
        assertEquals("Wrong received message", TEST_MESSAGE, receivedMessage.getText().toString());

        getInstrumentation().removeMonitor(receiverActivityMonitor);
    }
}