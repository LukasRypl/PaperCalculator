package cz.lukasrypl.papercalculator.operators;

import java.math.BigInteger;

import cz.lukasrypl.papercalculator.results.Result;
import cz.lukasrypl.papercalculator.results.SingleRowResult;

public class Plus extends Operator {

	public Plus() {
		operator = "+";
	}

	@Override
	public Result calculate(String number1, String number2) {
		BigInteger n1 = new BigInteger(number1);
		BigInteger n2 = new BigInteger(number2);
		return new SingleRowResult(n1.add(n2).toString());
	}

}
