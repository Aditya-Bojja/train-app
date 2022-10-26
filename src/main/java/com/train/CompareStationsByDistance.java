package com.train;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CompareStationsByDistance implements Comparator<String>{

	static Map<String, Integer> stationsFromHyd = new HashMap<>();
	
	static {
		stationsFromHyd.put("NGP", 400);
		stationsFromHyd.put("ITJ", 700);
		stationsFromHyd.put("BPL", 800);
		stationsFromHyd.put("AGA", 1300);
		stationsFromHyd.put("NDL", 1500);
		stationsFromHyd.put("PTA", 2600);
		stationsFromHyd.put("NJP", 3000);
		stationsFromHyd.put("GHY", 3500);
	}

	@Override
	public int compare(String station1, String station2) {
		if(stationsFromHyd.get(station1) > stationsFromHyd.get(station2))
			return -1;
		if(stationsFromHyd.get(station1) < stationsFromHyd.get(station2))
			return 1;
		return 0;
	}
	
}