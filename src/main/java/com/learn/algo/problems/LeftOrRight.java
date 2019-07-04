package com.learn.algo.problems;

import java.util.Arrays;
import java.util.Scanner;

public class LeftOrRight {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String inputLine1 = s.nextLine();
		String citiesTypeInput = s.nextLine();
		int N = Integer.parseInt(inputLine1.split(" ")[0]);
		int Q = Integer.parseInt(inputLine1.split(" ")[1]);
		String[] queries = new String[Q];
		for(int queryInput = 0; queryInput < Q; queryInput++) {
			queries[queryInput] = s.nextLine();
		}

		for(int queryInput = 0; queryInput < Q; queryInput++) {
			System.out.println(new LeftOrRight().getStepsRequired(queries[queryInput], citiesTypeInput, N));
		}
	}

	public int getStepsRequired(String query, String cityTypes, int N) {
		String[] queryValues = query.split(" ");
		int currentCity = Integer.parseInt(queryValues[0]);
		String[] cityType = cityTypes.split(" ");
		if(currentCity >= N) {
			return -1;
		}
		if(!Arrays.asList(cityType).contains(queryValues[1])) {
			return -1;
		}
		int targetCityType = Integer.parseInt(queryValues[1]);
		String direction = queryValues[2];
		int reachedCity = currentCity;
		int iterationCount = 1;
		int requiredSteps = 0;
		while(Integer.parseInt(cityType[reachedCity]) != targetCityType && iterationCount < N) {
			if("L".equals(direction)) {
				reachedCity = (reachedCity - 1 + N) % N;
			}else {	// R
				reachedCity = (reachedCity + 1) % N;
			}
			iterationCount++;
			requiredSteps++;
		}
		return requiredSteps;
	}

}
