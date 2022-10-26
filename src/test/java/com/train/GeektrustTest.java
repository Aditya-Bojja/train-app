package com.train;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class GeektrustTest {
	
	@Test
	public void testRemoveBogiesBeforeHyd() {
		List<String> allBogies = new ArrayList<>(Arrays.asList("NDL", "NDL", "KRN", "GHY", "SLM", "NJP", "NGP", "BLR"));
		Geektrust.removeBogiesBeforeHyd(allBogies);
		assertEquals(5, allBogies.size());
	}
	
	@Test
	public void testFormatBogiesToString() {
		List<String> allBogies = new ArrayList<>(Arrays.asList("NDL", "KRN", "GHY", "SLM"));
		assertEquals("NDL KRN GHY SLM", Geektrust.formatBogiesToString(allBogies));
	}
	
	@Test
	public void testGetBogiesAsList() {
		String trainName = "TRAIN_A ENGINE NDL NDL KRN GHY SLM NJP NGP BLR";
		assertEquals(8, Geektrust.getBogiesAsList(trainName).size());
	}

}
