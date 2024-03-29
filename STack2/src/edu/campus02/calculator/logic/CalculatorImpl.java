package edu.campus02.calculator.logic;

import java.util.Stack;

import edu.campus02.calculator.Calculator;
import edu.campus02.calculator.CalculatorException;

public class CalculatorImpl implements Calculator {

	private Stack<Double> stack_ = new Stack<Double>();

	@Override
	public double perform(Operation op) throws CalculatorException {

		double a = pop();
		double b = pop();

		switch (op) {
		case add:
			return a + b;
		case sub:
			return a - b;
		case div:

			double c = a / b;
			if (Double.isInfinite(c))
				throw new CalculatorException("Division by zero");
			return c;

		case mul:
			return a * b;

		default:
			break;
		}
		return 0;
	}

	@Override
	public double pop() throws CalculatorException {
		if (stack_.isEmpty())
			throw new CalculatorException();
		return stack_.pop();
	}

	@Override
	public void push(double v) {
		stack_.push(v);
	}

	@Override
	public void clear() {
		stack_.clear();
	}

}
