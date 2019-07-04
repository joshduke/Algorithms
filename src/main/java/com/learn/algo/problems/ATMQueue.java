package com.learn.algo.problems;

import java.util.Scanner;

public class ATMQueue {

	public static void main(String[] args) {
		//Scanner
		Scanner s = new Scanner(System.in);
		String numberofElements = s.nextLine();                 // Reading input from STDIN
		String heightString = s.nextLine();
		String[] heights = heightString.split(" ");
//		String heights[] = new String[] {"1", "2", "3", "4", "2","5"};
		System.out.println(new ATMQueue().getGroupCount(heights));
	}

	public int getGroupCount(String[] heightValues) {
		int groupCount = 0;
		int maxHeight = 1;
		int heightValue;
		for(int index = 0; index < heightValues.length; index++) {
			heightValue = Integer.parseInt(heightValues[index]);
			if(heightValue < maxHeight) {
				groupCount++;
			}
			maxHeight = heightValue;
		}

		return groupCount + 1;
	}

}
