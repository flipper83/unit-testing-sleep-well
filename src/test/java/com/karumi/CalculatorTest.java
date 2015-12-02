package com.karumi;

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
