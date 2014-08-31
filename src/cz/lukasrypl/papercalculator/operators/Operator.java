package cz.lukasrypl.papercalculator.operators;

import cz.lukasrypl.papercalculator.results.Result;

/**
 * Provides representation of supported operations.
 *
 */
public abstract class Operator {
	protected String operator;

	public abstract Result calculate(String number1, String number2);

	public static Operator getOperator(String op) {
		Operator result = null;
		switch (op) {
		case "+":
			result = new Plus();
			break;
		case "-":
			result = new Minus();
			break;
		case "*":
			result = new Multiply();
			break;
		default:
			throw new RuntimeException("Unknow operation " + op);
		}
		return result;
	}
	
	@Override
	public String toString() {
		return operator;
	}
}
