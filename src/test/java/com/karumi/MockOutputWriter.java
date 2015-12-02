package com.karumi;

public class MockOutputWriter implements OutputWriter {

    private int numCalls;
    private int argumentCatcher;

    @Override
    public void write(int value) {
        numCalls ++;
        argumentCatcher = value;
    }

    public int getNumCalls() {
        return numCalls;
    }

    public int getArgumentCatcher() {
        return argumentCatcher;
    }
}
