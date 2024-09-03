package test;

import static org.junit.jupiter.api.Assertions.*;

import edu.sjsu.assignment0.Main;
import org.junit.jupiter.api.Test;

public class UnitTest {

    Main.Calculator calculator = new Main.Calculator();

    @Test
    public void testAddition() {
        assertEquals(5.0, calculator.calculate(Main.Operation.ADD, 2, 3));
    }

    @Test
    public void testSubtraction() {
        assertEquals(1.0, calculator.calculate(Main.Operation.SUBTRACT, 3, 2));
    }

    @Test
    public void testMultiplication() {
        assertEquals(6.0, calculator.calculate(Main.Operation.MULTIPLY, 2, 3));
    }

    @Test
    public void testDivision() {
        assertEquals(2.0, calculator.calculate(Main.Operation.DIVIDE, 6, 3));
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(Main.Operation.DIVIDE, 6, 0);
        });
    }

    @Test
    public void testUnsupportedOperation() {
        assertThrows(UnsupportedOperationException.class, () -> {
            calculator.calculate(null, 6, 3);
        });
    }

    @Test
    public void testChainingOperations() {
        // Starting with 5, add 3, then multiply by 2
        Main.Operation[] operations = {
                Main.Operation.ADD,
                Main.Operation.MULTIPLY
        };

        Number[] operands = {3, 2};

        Number initialValue = 5;
        Number expected = 16;

        Number result = calculator.chainOperations(initialValue, operations, operands);

        assertEquals(expected.doubleValue(), result.doubleValue(), "Chained operations should result in 16");
    }

    @Test
    public void testChainingOperationsWithDifferentOperations() {
        // Starting with 10, subtract 2, then divide by 4
        Main.Operation[] operations = {
                Main.Operation.SUBTRACT,
                Main.Operation.DIVIDE
        };

        Number[] operands = {2, 4};

        Number initialValue = 10;
        Number expected = 2;

        Number result = calculator.chainOperations(initialValue, operations, operands);

        assertEquals(expected.doubleValue(), result.doubleValue(), "Chained operations should result in 2");
    }

    @Test
    public void testChainingOperationsWithZeroDivision() {
        // Starting with 10, subtract 2, then try to divide by 0
        Main.Operation[] operations = {
                Main.Operation.SUBTRACT,
                Main.Operation.DIVIDE
        };

        Number[] operands = {2, 0};

        Number initialValue = 10;

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.chainOperations(initialValue, operations, operands);
        }, "Division by zero should throw an IllegalArgumentException");
    }
}
