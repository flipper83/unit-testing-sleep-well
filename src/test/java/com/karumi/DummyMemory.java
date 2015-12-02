package com.karumi;

/**
 * @author flipper83
 */
public class DummyMemory implements Memory {
    @Override
    public void put(int value, int position) {
    }

    @Override
    public int get(int memoryPosition) {
        return 0;
    }
}
