package cz.lukasrypl.papercalculator.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cz.lukasrypl.papercalculator.operators.Multiply;
import cz.lukasrypl.papercalculator.results.Result;

public class MultiplyTest {

	@Test
	public void testCalculate() {
		Multiply m = new Multiply();

		Result r = m.calculate("10", "22");
		assertEquals(" 20\n20 \n---\n220", r.toString());
	}

	@Test
	public void inputShifting() {
		Multiply m = new Multiply();

		Result r = m.calculate("325", "4405");
		assertEquals("   1625\n     0 \n 1300  \n1300   \n-------\n1431625", r.toString());
	}

}
