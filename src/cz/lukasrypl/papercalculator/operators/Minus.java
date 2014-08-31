package cz.lukasrypl.papercalculator.operators;

import java.math.BigInteger;

import cz.lukasrypl.papercalculator.results.SingleRowResult;

public class Minus extends Operator {

	public Minus() {
		operator = "-";
	}

	@Override
	public SingleRowResult calculate(String number1, String number2) {
		BigInteger n1 = new BigInteger(number1);
		BigInteger n2 = new BigInteger(number2);
		return new SingleRowResult(n1.subtract(n2).toString());
	}

}
