package com.learn.algo.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Winner {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			Map<Integer, String> participants = new HashMap<Integer, String>();
			participants.put(1, "Arpa");
			participants.put(2, "Dishant");
			Winner winnerTest = new Winner();
			double totalTestCase =  Double.parseDouble(s.nextLine());
			List<Integer> winners = new LinkedList<Integer>();
			for(int i = 0; i < totalTestCase; i++) {
				winners.add(winnerTest.decideWinner(s.nextLine().split(" ")));
			}
			s.close();
			for(int winnerIndex : winners) {
				System.out.println(participants.get(winnerIndex));
			}

		}catch(Exception e) {
			e.printStackTrace();
			return;
		}
	}

	public int decideWinner(String[] inputs) {
		double N = Double.parseDouble(inputs[0]);
		double K = Double.parseDouble(inputs[1]);
		double endIteration = getPossibleEndIteration(N, K);
		inputs = null;
		return findIterationPerson(endIteration);
	}

	private double getPossibleEndIteration(double N, double K) {
		double M = 1000000007;
		return N%M/K%M;
	}

	public boolean isEvenNumber(int number) {
		return number > 1 && number%2 == 0;
	}

	private int findIterationPerson(double iterationCount) {
		double numberOfPersons = 2;
		double calc_val = iterationCount;
		while(calc_val >= 2) {
			calc_val = calc_val/numberOfPersons;
		}

		if(calc_val == 1) {	// Even 
			/*return "Dishant";*/
			return 2;
		}else {// Odd
			/*return "Arpa";*/
			return 1;
		}
	}

}