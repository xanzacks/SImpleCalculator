package edu.sjsu.assignment0;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }

    public static class Calculator {

        public Number calculate(Operation op, Number num1, Number num2) {
            if (op == null) {
                throw new UnsupportedOperationException("Operation not supported.");
            }
            switch (op) {
                case ADD:
                    return num1.doubleValue() + num2.doubleValue();
                case SUBTRACT:
                    return num1.doubleValue() - num2.doubleValue();
                case MULTIPLY:
                    return num1.doubleValue() * num2.doubleValue();
                case DIVIDE:
                    if (num2.doubleValue() == 0) {
                        throw new IllegalArgumentException("Division by zero is not allowed.");
                    }
                    return num1.doubleValue() / num2.doubleValue();
                default:
                    throw new UnsupportedOperationException("Operation not supported.");
            }
        }

        public Number chainOperations(Number initialValue, Operation[] operations, Number[] operands) {
            Number result = initialValue;
            for (int i = 0; i < operations.length; i++) {
                result = calculate(operations[i], result, operands[i]);
            }
            return result;
        }
    }




    public static void main(String[] args) {
	// write your code here
    }
}
