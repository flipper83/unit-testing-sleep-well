package com.karumi;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MultiplyTest {
    @Test
    public void shouldReturnValidResultWhenMultiplyTwoValues() throws Exception {
        Multiply multiply = new Multiply(new Addition());
        int multiplyValue = multiply.multiply(2, 3);
        assertEquals(6, multiplyValue);
    }
}
