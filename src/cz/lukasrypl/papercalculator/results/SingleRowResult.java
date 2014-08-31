package cz.lukasrypl.papercalculator.results;

/**
 * Result representation for addition, subtraction and multiplication by numbers
 * smaller than ten.
 *
 */
public class SingleRowResult extends Result {
	private String value;

	public SingleRowResult(String string) {
		value = string;
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public int getLineWidth() {
		return value.length();
	}

	@Override
	public String getFormattedResult(int maximalWidthOfInputs) {

		StringBuffer sb = new StringBuffer();
		int padding = maximalWidthOfInputs - getLineWidth();

		for (int i = 0; i < padding; i++) {
			sb.append(" ");
		}

		return sb.toString() + value;
	}

}
