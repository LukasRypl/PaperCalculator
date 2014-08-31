package cz.lukasrypl.papercalculator.results;

public abstract class Result {

	/**
	 * @return Number of characters of the longest result line (including white
	 *         spaces).
	 */
	public abstract int getLineWidth();

	/**
	 * Adds padding to numbers so they are neatly aligned.
	 * 
	 * @param maximalWidthOfInputs
	 * @return one line or multi line string in case of multiplication.
	 */
	public abstract String getFormattedResult(int maximalWidthOfInputs);
}
