package cz.lukasrypl.papercalculator.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cz.lukasrypl.papercalculator.results.MultiRowResult;

public class MultiRowResultTest {

	@Test
	public void testToString() {
		MultiRowResult r = new MultiRowResult();
		r.add("10");
		r.add("2");
		r.add("3");
		assertEquals(" 10\n 2 \n3  \n---\n330", r.toString());
	}

	@Test
	public void testGetLineWidth() {
		MultiRowResult r = new MultiRowResult();
		r.add("1");
		r.add("2");
		assertEquals(2, r.getLineWidth());
		r.add("30");
		assertEquals(4, r.getLineWidth());
	}
}
