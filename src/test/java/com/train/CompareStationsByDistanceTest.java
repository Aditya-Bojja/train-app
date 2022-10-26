package com.train;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CompareStationsByDistanceTest {
	
	CompareStationsByDistance compareStations = new CompareStationsByDistance();
	
	@Test
	public void testCompareShouldSwap() {
		int result = compareStations.compare("NGP", "AGA");
		assertEquals(1, result);
	}
	
	@Test
	public void testCompareShouldNotSwap() {
		int result = compareStations.compare("AGA", "NGP");
		assertEquals(-1, result);
	}
	
	@Test
	public void testCompareEqual() {
		int result = compareStations.compare("AGA", "AGA");
		assertEquals(0, result);
	}

}
