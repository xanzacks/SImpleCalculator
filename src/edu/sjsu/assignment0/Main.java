package edu.sjsu.assignment0;

import java.util.function.BiFunction;

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

        public Number chainOperations(Number initialValue, BiFunction<Number, Number, Number>... operations) {
            Number result = initialValue;
            for (BiFunction<Number, Number, Number> operation : operations) {
                result = operation.apply(result, result);
            }
            return result;
        }
    }




    public static void main(String[] args) {
	// write your code here
    }
}
