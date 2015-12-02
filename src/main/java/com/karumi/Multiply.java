package com.karumi;

public class Multiply {
    private final Addition addition;

    public Multiply(Addition addition) {
        this.addition = addition;
    }

    public int multiply(int value1, int value2) {
        int acu = 0;
        for (int i = 0; i < value2; i++) {
            acu = addition.add(acu, value1);
        }

        return acu;
    }


}
