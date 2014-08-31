package cz.lukasrypl.papercalculator.operators;

import java.math.BigInteger;

import cz.lukasrypl.papercalculator.results.MultiRowResult;
import cz.lukasrypl.papercalculator.results.Result;
import cz.lukasrypl.papercalculator.results.SingleRowResult;

public class Multiply extends Operator {

	public Multiply() {
		operator = "*";
	}

	@Override
	public Result calculate(String number1, String number2) {
		BigInteger n1 = new BigInteger(number1);
		BigInteger n2 = new BigInteger(number2);
		if (number2.length() == 1) {
			return new SingleRowResult(n1.multiply(n2).toString());
		} else {
			return multiRowResult(n1, n2);
		}
	}

	private MultiRowResult multiRowResult(BigInteger n1, BigInteger n2) {
		MultiRowResult result = new MultiRowResult();
		while (n2.compareTo(BigInteger.ZERO) > 0) {
			result.add(n2.mod(BigInteger.TEN).multiply(n1).toString());
			n2 = n2.divide(BigInteger.TEN);
		}
		return result;
	}

}
