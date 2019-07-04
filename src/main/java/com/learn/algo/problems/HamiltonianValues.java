package com.learn.algo.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HamiltonianValues {


	public static void main(String[] args) {

		//Scanner
		Scanner s = new Scanner(System.in);
		String numberofElements = s.nextLine();                 // Reading input from STDIN
		//String marks[] = new String[] { "98", "12", "45", "58", "38", "42", "75"};
		String marksString = s.nextLine();
		String[] marks = marksString.split(" ");
		System.out.println(Arrays.asList(new HamiltonianValues().findCuriousKidMarks(marks)));
	}

	public String[] findCuriousKidMarks(String[] marks) {
		int[] marksInteger = new int[marks.length];
		for(int index = 0; index < marks.length; index++) {
			marksInteger[index] = Integer.parseInt(marks[index]);
		}
		List<String> curiousKidsMark = new LinkedList<String>();
		int curiousKid = -1;
		while(curiousKid < marks.length-1) {
			int maxValueIndex = findMax(Arrays.copyOfRange(marksInteger, curiousKid+1, marksInteger.length));
			/*if(curiousKid != -1) {
				maxValueIndex = maxValueIndex + 1;
			}else {
				maxValueIndex = maxValueIndex + 2;
			}*/
			curiousKid = curiousKid + maxValueIndex + 1;
			curiousKidsMark.add(marks[curiousKid]);
		}
		String[] curiouskidsMarksDisplay = new String[curiousKidsMark.size()];
		for(int k = 0; k<curiousKidsMark.size(); k++) {
			curiouskidsMarksDisplay[k] = curiousKidsMark.get(k);
		}
		return curiouskidsMarksDisplay;
	}

	public int findMax(int[] elements) {
		int maxValue = -1;
		int maxValueIndex = -1;
		for(int index = 0; index < elements.length; index++) {
			if(elements[index] > maxValue) {
				maxValue = elements[index];
				maxValueIndex = index;
			}
		}
		return maxValueIndex;
	}

}
