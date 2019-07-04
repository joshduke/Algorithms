package com.learn.algo.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LaddusFight {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LaddusFight test = new LaddusFight();
		int testCases = Integer.parseInt(scanner.nextLine());
		for(int testCase = 0; testCase < testCases; testCase++) {
			int N = Integer.parseInt(scanner.nextLine());
			String laddusCountString = scanner.nextLine();
			test.findChallengeScores(laddusCountString.split(" "));
		}
	}

	private void findChallengeScores(String[] laddusCount) {
		Map<String, Integer> frequencyMap = getFrequencyMap(laddusCount);
		int currentFrequency;
		String winnerScore;
		for(int index = 0; index < laddusCount.length; index++) {
			currentFrequency = frequencyMap.get(laddusCount[index]);
			winnerScore = "-1";
			for(int j = index+1; j < laddusCount.length; j++) {
				if(frequencyMap.get(laddusCount[j]) > currentFrequency) {
					winnerScore = laddusCount[j];
					break;
				}
			}
			System.out.print(winnerScore + " ");
		}

	}

	private Map<String, Integer> getFrequencyMap(String[] laddusCount){
		Map<String, Integer> frequencyMap = new HashMap<String, Integer>();
		for (String i : laddusCount) {
			if(frequencyMap.get(i) != null) {
				frequencyMap.put(i, frequencyMap.get(i)+1);
			}else {
				frequencyMap.put(i, 1);
			}
		}
		return frequencyMap;
	}
}
