package com.karumi;

/**
 * @author flipper83
 */
public class StubInputReader implements InputReader {
    private final int[] values;
    private int count = 0;

    public StubInputReader(int... values) {
        this.values = values;
    }

    @Override
    public int read() {
        int response = values[count];
        count = (count + 1) % values.length;
        return response;
    }
}
