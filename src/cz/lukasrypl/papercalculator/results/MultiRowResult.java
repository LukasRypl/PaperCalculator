package cz.lukasrypl.papercalculator.results;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import cz.lukasrypl.papercalculator.CalculationRow;

/**
 * Multiplication has a special result format consisting of multiple lines, one
 * for each multiplication digit.
 *
 */
public class MultiRowResult extends Result {
	private List<SingleRowResult> subresults = new ArrayList<SingleRowResult>();

	public void add(String string) {
		subresults.add(new SingleRowResult(string));
	}

	private String getTotalSum() {
		int depth = 0;
		BigInteger result = new BigInteger("0");
		for (SingleRowResult line : subresults) {
			result = result.add(new BigInteger(line.toString()).multiply(BigInteger.TEN.pow(depth)));
			depth++;
		}
		return result.toString();
	}

	private void padding(StringBuilder sb, int i) {
		for (int j = 0; j < i; j++) {
			sb.append(" ");
		}
	}

	@Override
	public int getLineWidth() {
		// the last line is always non-zero
		int amountOfNumbers = subresults.get(subresults.size() - 1).toString().length();
		// one char padding for each extra line
		return amountOfNumbers + subresults.size() - 1;
	}

	/**
	 * @return Divider matching the full width.
	 */
	public String getDivider() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < getLineWidth(); i++) {
			sb.append(CalculationRow.DIVIDER_CHAR);
		}
		return sb.toString();
	}
	
	@Override
	public String getFormattedResult(int maximalWidthOfInputs) {
		return toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int depth = 0;
		for (SingleRowResult line : subresults) {
			// heading spaces
			padding(sb, getLineWidth() - depth - line.toString().length()); 
			sb.append(line);
			padding(sb, depth); // trailing spaces
			sb.append("\n");
			depth++;
		}
		sb.append(getDivider() + "\n");
		sb.append(getTotalSum());
		return sb.toString();
	}
}
