package cz.lukasrypl.papercalculator.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cz.lukasrypl.papercalculator.CalculationRow;
import cz.lukasrypl.papercalculator.PaperCalculator;

public class PaperCalculatorTest {

	@Test
	public void testSplitString() {
		PaperCalculator pc = new PaperCalculator();
		CalculationRow row = pc.parseCalculationInputRow("1+2");
		assertEquals(" 1", row.getFormattedRow1());
		assertEquals("+2", row.getFormattedRow2());
		assertEquals("+", row.getOperation().toString());

		row = pc.parseCalculationInputRow("2-1");
		assertEquals(" 2", row.getFormattedRow1());
		assertEquals("-1", row.getFormattedRow2());
		assertEquals("-", row.getOperation().toString());

		row = pc.parseCalculationInputRow("2*4");
		assertEquals(" 2", row.getFormattedRow1());
		assertEquals("*4", row.getFormattedRow2());
		assertEquals("*", row.getOperation().toString());
	}

}
