package cz.lukasrypl.papercalculator.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cz.lukasrypl.papercalculator.CalculationRow;

public class CalculationInputRowTest {

	@Test
	public void testGetMaximalLengthOfInput() throws Exception {
		CalculationRow row = new CalculationRow("1", "2", "+");
		assertEquals("two single digits", 2, row.getMaximalWidthOfInputs());

		row = new CalculationRow("1", "2345", "+");
		assertEquals("second number longer", 5, row.getMaximalWidthOfInputs());

		row = new CalculationRow("123", "21", "+");
		assertEquals("both same", 3, row.getMaximalWidthOfInputs());

		row = new CalculationRow("12345", "1", "+");
		assertEquals("first longer", 5, row.getMaximalWidthOfInputs());
	}

	@Test
	public void testGetFormattedRow1() throws Exception {
		CalculationRow row = new CalculationRow("1", "2", "+");
		assertEquals("Single digit", " 1", row.getFormattedRow1());

		row = new CalculationRow("11", "2", "+");
		assertEquals("Double digit", "11", row.getFormattedRow1());

		row = new CalculationRow("1", "22", "+");
		assertEquals("One digit with two spaces", "  1", row.getFormattedRow1());
	}

	@Test
	public void testGetFormattedRow2() throws Exception {
		CalculationRow row = new CalculationRow("1", "2", "+");
		assertEquals("Single digit", "+2", row.getFormattedRow2());

		row = new CalculationRow("123", "2", "+");
		assertEquals("Padded digit", " +2", row.getFormattedRow2());
	}

	@Test
	public void testGetDivider() throws Exception {
		CalculationRow row = new CalculationRow("1", "2", "+");
		assertEquals("Single digit", "--", row.getDivider());

		row = new CalculationRow("100", "10", "*");
		assertEquals("Multiplication formatting", " ---", row.getDivider());
	}

	@Test
	public void testGetFormattedResult() throws Exception {
		CalculationRow row = new CalculationRow("1", "2", "+");
		assertEquals(" 3", row.getFormattedResult());

		row = new CalculationRow("1", "22", "+");
		assertEquals(" 23", row.getFormattedResult());
	}

}
