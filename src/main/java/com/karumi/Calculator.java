package com.karumi;

public class Calculator {
    private static final int MAX_ARGS = 2;
    private final OutputWriter outputWriter;
    private final Addition addition;
    private final Multiply multiply;
    private final InputReader inputReader;
    private final Memory memory;
    private int countValue = 0;
    private int values[] = new int[MAX_ARGS];
    private int lastResult;

    public Calculator(OutputWriter outputWriter, InputReader inputReader, Memory memory) {
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
        this.memory = memory;
        this.addition = new Addition();
        this.multiply = new Multiply(addition);

    }

    public void insertValue() {
        int readValue = inputReader.read();
        writeValue(readValue);
    }

    public void insertValueFromMemory(int position) {
        int readValue = memory.get(position);
        writeValue(readValue);
    }

    private void writeValue(int readValue) {
        values[countValue] = readValue;
        countValue = (countValue + 1) % MAX_ARGS;
        outputWriter.write(readValue);
    }


    public void add() {
        int result = addition.add(values[0], values[1]);
        outputWriter.write(result);
        lastResult = result;
    }

    public void multiply() {
        int result = multiply.multiply(values[0], values[1]);
        outputWriter.write(result);
        lastResult = result;
    }

    public void save(int position) {
        memory.put(lastResult, position);
    }
}
