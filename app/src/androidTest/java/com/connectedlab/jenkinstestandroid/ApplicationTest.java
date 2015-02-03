package com.connectedlab.jenkinstestandroid;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.InstrumentationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends InstrumentationTestCase {
    public void testFail() {
        assertEquals(false, true);
    }
}