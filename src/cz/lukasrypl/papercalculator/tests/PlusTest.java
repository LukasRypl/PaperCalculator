package cz.lukasrypl.papercalculator.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cz.lukasrypl.papercalculator.operators.Plus;

public class PlusTest {

	@Test
	public void testCalculate() throws Exception {
		Plus p = new Plus();
		StringBuilder input = new StringBuilder();
		StringBuilder output = new StringBuilder("1");
		for (int i = 0; i < 500; i++) {
			input.append("9");
			output.append("0");
		}
		assertEquals(output.toString(), p.calculate(input.toString(), "1").toString());
//		System.out.println(output);
	}

}
