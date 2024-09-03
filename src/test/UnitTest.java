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
}
