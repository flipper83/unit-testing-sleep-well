package com.karumi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author flipper83
 */
public class FakeMemory implements Memory {
    Map<Integer, Integer> mem = new HashMap<Integer, Integer>();

    @Override
    public void put(int value, int position) {
        mem.put(position, value);
    }

    @Override
    public int get(int memoryPosition) {
        return mem.get(memoryPosition);
    }
}
