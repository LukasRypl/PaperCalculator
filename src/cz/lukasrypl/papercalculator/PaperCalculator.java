package cz.lukasrypl.papercalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for pen-and-paper-like calculator supporting addition,
 * subtraction and multiplication with special formatting rules.
 * 
 * https://drive.google.com/folderview?id=0Bw9orE-PFQp1YXduN0dFUVRLZm8
 *
 */
public class PaperCalculator {

	private List<CalculationRow> input = new ArrayList<CalculationRow>();

	public static void main(String[] args) {
		PaperCalculator calculator = new PaperCalculator();
		calculator.readInput();
		calculator.calculate();
		calculator.printResults();
	}

	/**
	 * Reads the input and stores the parsed values to the input list.
	 */
	private void readInput() {
		Scanner sc = new Scanner(System.in);
		try {
			int numberOfLines = Integer.parseInt(sc.nextLine());

			for (int i = 0; i < numberOfLines; i++) {
				input.add(parseCalculationInputRow(sc.nextLine()));
			}
		} finally {
			sc.close();
		}
	}

	public CalculationRow parseCalculationInputRow(String line) {
		String[] numbers = line.split("[\\+\\-\\*]");
		String op = line.substring(numbers[0].length(), numbers[0].length() + 1);
		return new CalculationRow(numbers[0], numbers[1], op);
	}

	/**
	 * Computes results for all parsed lines.
	 */
	private void calculate() {
		for (CalculationRow row : input) {
			row.calculate();
		}
	}

	/**
	 * Prints the formatted input and the result.
	 */
	private void printResults() {
		for (CalculationRow row : input) {
			System.out.println(row.getFormattedRow1());
			System.out.println(row.getFormattedRow2());
			System.out.println(row.getDivider());
			System.out.println(row.getFormattedResult());
			System.out.println();
		}
	}
}
