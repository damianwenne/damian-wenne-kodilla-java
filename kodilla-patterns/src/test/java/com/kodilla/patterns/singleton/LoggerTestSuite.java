package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        //When
        Logger.getInstance().log("abc123");
        String result = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("abc123", result);
    }
}
