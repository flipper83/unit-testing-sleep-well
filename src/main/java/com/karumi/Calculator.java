package com.karumi;

/**
 * @author flipper83
 */
public class Calculator {
    private static final int MAX_ARGS = 2;
    private final OutputWriter outputWriter;
    private final Addition addition;
    private final Multiply multiply;
    private final InputReader inputReader;
    private int countValue = 0;
    private int values[] = new int[MAX_ARGS];

    public Calculator(OutputWriter outputWriter, InputReader inputReader) {
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
        this.addition = new Addition();
        this.multiply = new Multiply(addition);
    }

    public void insertValue() {
        int readValue = inputReader.read();
        values[countValue] = readValue;
        countValue = (countValue + 1) % MAX_ARGS;
        outputWriter.write(readValue);
    }

    public void add() {
        int result = addition.add(values[0], values[1]);
        outputWriter.write(result);
    }

    public void multiply() {
        int result = multiply.multiply(values[0], values[1]);
        outputWriter.write(result);
    }
}
