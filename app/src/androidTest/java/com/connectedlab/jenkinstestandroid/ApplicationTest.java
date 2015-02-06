package com.connectedlab.jenkinstestandroid;

import android.test.ActivityInstrumentationTestCase2;
import android.app.Instrumentation.ActivityMonitor;
import android.test.TouchUtils;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public ApplicationTest() {
        super(MainActivity.class);
    }

    public void testFail() {
        assertEquals(true, true);
    }

    public void testActivity() {
        // Set up an ActivityMonitor
        ActivityMonitor receiverActivityMonitor =
                getInstrumentation().addMonitor(MainActivity.class.getName(),
                        null, false);

// Validate that ReceiverActivity is started
        MainActivity mainActivity = (MainActivity)
                receiverActivityMonitor.waitForActivityWithTimeout(30000);
        TouchUtils.clickView(this, mainActivity.findViewById(R.id.button));
        assertNotNull("ReceiverActivity is null", mainActivity);
        assertEquals("Monitor for ReceiverActivity has not been called",
                1, receiverActivityMonitor.getHits());
        assertEquals("Activity is of wrong type",
                MainActivity.class, mainActivity.getClass());
    // Remove the ActivityMonitor
        getInstrumentation().removeMonitor(receiverActivityMonitor);
    }
}