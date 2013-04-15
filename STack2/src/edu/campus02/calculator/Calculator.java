package edu.campus02.calculator;

// new Comment addede by Martin Vogt

public interface Calculator {

	enum Operation {
		add, sub, mul, div
	};
	
	//test
	
	void push(double value);
	
	double pop() throws CalculatorException;
	
	double perform(Operation op) throws CalculatorException;
	
	void clear(); 
}
