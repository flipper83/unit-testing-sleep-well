package com.karumi;

import java.util.ArrayList;
import java.util.List;

public class SpyMemory implements Memory {
    List<Integer> values = new ArrayList<Integer>();

    @Override
    public void put(int value, int position) {
        values.add(value);
    }

    @Override
    public int get(int memoryPosition) {
        return 0;
    }

    public List<Integer> getValues() {
        return values;
    }
}
