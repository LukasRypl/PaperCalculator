package cz.lukasrypl.papercalculator;

import cz.lukasrypl.papercalculator.operators.Operator;
import cz.lukasrypl.papercalculator.results.Result;

/**
 * Two numbers, operator and result.
 *
 */
public class CalculationRow {
	public static final String DIVIDER_CHAR = "-";
	
	private String number1, number2;
	private Operator operator;
	private Result result;

	public CalculationRow(String number1, String number2, String operator) {
		this.number1 = number1;
		this.number2 = number2;
		this.operator = Operator.getOperator(operator);
	}
	
	public void calculate() {
		result = operator.calculate(number1, number2);		
	}

	public int getMaximalWidthOfInputs() {
		return Math.max(number1.length(), number2.length() + 1); // one char for operator
	}
	
	public int getMaximalWidthIncludingResult() {
		if (result == null) {
			calculate();
		}
		return Math.max(getMaximalWidthOfInputs(), result.getLineWidth());
	}

	public String getFormattedRow1() {
		StringBuffer sb = new StringBuffer();
		int padding = getMaximalWidthIncludingResult() - number1.length();
		
		for (int i= 0; i< padding; i++) {
			sb.append(" ");
		}
		
		return sb.toString() + number1;
	}

	public String getFormattedRow2() {
		StringBuffer sb = new StringBuffer();
		int padding = getMaximalWidthIncludingResult() - number2.length() - 1;
		
		for (int i= 0; i< padding; i++) {
			sb.append(" ");
		}
		
		return sb.toString() + operator.toString() + number2;
	}

	public String getDivider() {
		StringBuffer sb = new StringBuffer();
		// leading empty spaces in case of multiplication
		for (int i= 0; i< getMaximalWidthIncludingResult()-getMaximalWidthOfInputs();i++) {
			sb.append(" ");
		}
		for (int i= 0; i< getMaximalWidthOfInputs(); i++) {
			sb.append(DIVIDER_CHAR);
		}
		return sb.toString();
	}
	
	public String getFormattedResult() {
		
 		if (result == null) {
 			calculate();
 		}
		return result.getFormattedResult(getMaximalWidthOfInputs());
	}

	public Operator getOperation() {
		return operator;
	}
}
