package com.karumi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AdditionTest {

    @Test
    public void shouldReturnAValidSumWhenReceivedTwoValidArguments() throws Exception{
        Addition adition = new Addition();
        int add = adition.add(2, 2);
        assertEquals(4, add);
    }
}
