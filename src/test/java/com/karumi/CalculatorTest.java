package com.karumi;

import java.util.List;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTest {
    @Test
    public void shouldShowAdditionResultOnTheOutputStreamWhenCallAdition() throws Exception {
        MockOutputWriter outputWriter = givenOutputWriter();
        InputReader inputReader = givenInputReader(2, 3);
        Memory memory = givenDummyMemory();
        Calculator calculator = givenCalculator(outputWriter, inputReader, memory);

        calculator.insertValue();
        calculator.insertValue();
        calculator.add();

        assertEquals(3, outputWriter.getNumCalls());
        assertEquals(5, outputWriter.getArgumentCatcher());
    }

    @Test
    public void shouldShowAdditionResultWithTheMemoryWhenCallAditionWithSavedValue() throws Exception {
        MockOutputWriter outputWriter = givenOutputWriter();
        InputReader inputReader = givenInputReader(2, 3, 2);
        Memory memory = givenFakeMemory();
        Calculator calculator = givenCalculator(outputWriter, inputReader, memory);

        calculator.insertValue();
        calculator.insertValue();
        calculator.add();
        calculator.save(0);
        calculator.insertValue();
        calculator.insertValueFromMemory(0);
        calculator.add();

        assertEquals(7, outputWriter.getArgumentCatcher());
    }

    @Test
    public void shouldStoreInMemoryLastOperationResult() throws Exception {
        MockOutputWriter outputWriter = givenOutputWriter();
        InputReader inputReader = givenInputReader(2, 3, 2, 2);
        SpyMemory memory = givenSpyMemory();
        Calculator calculator = givenCalculator(outputWriter, inputReader, memory);

        calculator.insertValue();
        calculator.insertValue();
        calculator.add();
        calculator.save(0);
        calculator.insertValue();
        calculator.insertValue();
        calculator.save(1);

        List<Integer> values = memory.getValues();
        assertEquals(5, values.get(0).intValue());
        assertEquals(5, values.get(1).intValue());
    }

    private SpyMemory givenSpyMemory() {
        return new SpyMemory();
    }

    private Memory givenFakeMemory() {
        return new FakeMemory();
    }

    private Memory givenDummyMemory() {
        return new DummyMemory();
    }

    private InputReader givenInputReader(int... values) {
        return new StubInputReader(values);
    }

    private MockOutputWriter givenOutputWriter() {
        return new MockOutputWriter();
    }

    private Calculator givenCalculator(MockOutputWriter outputWriter, InputReader inputReader,
                                       Memory memory) {
        return new Calculator(outputWriter, inputReader, memory);
    }
}
