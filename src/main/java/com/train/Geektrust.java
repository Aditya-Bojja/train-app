package com.train;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Geektrust {
	
	public static void removeBogiesBeforeHyd(List<String> stationsList) {
		List<String> stationsBeforeHyd = new ArrayList<>(Arrays.asList("TVC", "SRR", "MAQ", "MAO", 
				"PNE", "CHN", "SLM", "BLR", "KRN"));
		
		stationsList.removeIf(stationsBeforeHyd::contains);
	}
	
	
	public static String formatBogiesToString(List<String> bogies) {
		return bogies.toString().replace("[", "").replace("]", "").replace(",", "");
	}
	
	
	public static List<String> getBogiesAsList(String trainName){
		String[] arrayOfBogies = trainName.split(" ");
		List<String> listOfBogies = new ArrayList<>(Arrays.asList(arrayOfBogies));
		listOfBogies.remove("ENGINE");
		listOfBogies.remove("TRAIN_A");
		listOfBogies.remove("TRAIN_B");
		return listOfBogies;
	}
	

	public static void main(String[] args) {
		
		String inputFilePath = args[0];
		String trainA = "";
		String trainB = "";
		
		try {  
            File inputArgsFile = new File(inputFilePath);  
            Scanner dataReader = new Scanner(inputArgsFile);  
            while (dataReader.hasNextLine()) {
            	String inputTrainName = dataReader.nextLine();
            	if(inputTrainName.startsWith("TRAIN_A")) {
            		trainA = inputTrainName;
            	} else if(inputTrainName.startsWith("TRAIN_B")) {
            		trainB = inputTrainName;
            	}
            }  
            dataReader.close();  
        } catch (FileNotFoundException exception) {  
            System.out.println("Could not find the specified file");  
            exception.printStackTrace();  
        }
		
		List<String> bogiesOfTrainA = getBogiesAsList(trainA);
		List<String> bogiesOfTrainB = getBogiesAsList(trainB);
		
		removeBogiesBeforeHyd(bogiesOfTrainA);
		removeBogiesBeforeHyd(bogiesOfTrainB);
		
		List<String> bogiesOfTrainAB = new ArrayList<>();
		bogiesOfTrainAB.addAll(bogiesOfTrainA);
		bogiesOfTrainAB.addAll(bogiesOfTrainB);
		bogiesOfTrainAB.removeAll(new ArrayList<>(Arrays.asList("HYB")));
		
		Collections.sort(bogiesOfTrainAB, new CompareStationsByDistance());
		
		String bogiesAtHydTrainA = formatBogiesToString(bogiesOfTrainA);
		String bogiesAtHydTrainB = formatBogiesToString(bogiesOfTrainB);
		String bogiesAfterHyd = formatBogiesToString(bogiesOfTrainAB);
		
		System.out.println("ARRIVAL TRAIN_A ENGINE " + bogiesAtHydTrainA);
		System.out.println("ARRIVAL TRAIN_B ENGINE " + bogiesAtHydTrainB);
		System.out.println("DEPARTURE TRAIN_AB ENGINE ENGINE " + bogiesAfterHyd);

	}

}