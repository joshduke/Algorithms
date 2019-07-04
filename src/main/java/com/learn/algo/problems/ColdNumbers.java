package com.learn.algo.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ColdNumbers {

	public static void main(String args[] ) throws Exception {
		TestClass tc = new TestClass();
		tc.readInput();
		tc.processInputAndPrintOutput();
	}

}


/* IMPORTANT: Multiple classes and nested static classes are supported */

class TestClass {

	List<ColdNumberInput> inputList = new LinkedList<ColdNumberInput>();

	/*public static void main(String args[] ) throws Exception {
		TestClass tc = new TestClass();
		tc.readInput();
		tc.processInputAndPrintOutput();
	}*/

	public void readInput() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();                // Reading input from STDIN
		int testCaseCount = Integer.parseInt(input1);
		while(testCaseCount > 0) {
			String numberOfElementsInArray = br.readLine();
			String arrayElements = br.readLine();
			String numberOfQuery = br.readLine();
			int queryCount = Integer.parseInt(numberOfQuery);
			String[] queries = new String[queryCount];
			for(int q = 0; q < queryCount; q++) {
				queries[q] = br.readLine();
			}
			ColdNumberInput input = new ColdNumberInput();
			input.setArrayElements(arrayElements);
			input.setQueries(queries);
			inputList.add(input);
			testCaseCount--;
		}
	}

	public void processInputAndPrintOutput() {
		String SPACE = " ";
		for(ColdNumberInput input : this.inputList) {
			String inputArray = input.getArrayElements();
			String[] queries = input.getQueries();
			String[] elements = inputArray.split(SPACE);
			int[] arrayElements = new int[elements.length];
			for(int i = 0; i < elements.length; i++) {
				arrayElements[i] = Integer.parseInt(elements[i]);
				if(isOldNumber(arrayElements[i])) {
					input.addOldNumberIndex(i+1);
				}else {
					input.addColdNumberIndex(i+1);
				}
			}

			for(String query : queries) {
				String[] queryValues = query.split(SPACE);
				int startIndex = Integer.parseInt(queryValues[0]);
				int endIndex = Integer.parseInt(queryValues[1]);
				System.out.println(stepsRequiredToBalance(input.getOldNumberCount(startIndex, endIndex), 
						input.getColdNumberCount(startIndex, endIndex)));
			}
		}
	}

	/*public boolean isOldNumber(int number) {
		int divisor = number/2;
		if(divisor != 0 && number % divisor == 0) {
			return true;
		}else {
			return false;
		}
	}*/

	public boolean isOldNumber(int number) {
		if(number != 0){
			int divisor = number/2;
			if(divisor != 0 && 
					(number % divisor == 0 || number % (divisor+1) == 0)
				) {
				return true;
			}else {
				return false;
			}   
		}else{
			return false;
		}

	}

	public int stepsRequiredToBalance(int oldNumberCount, int coldNumberCount) {

		if(coldNumberCount > oldNumberCount) {
			return (coldNumberCount - oldNumberCount);
		}else {
			return 0;
		}

	}

}

class ColdNumberInput{

	String arrayElements;
	String[] queries;
	List<Integer> coldNumberIndexes = new LinkedList<Integer>();
	List<Integer> oldNumberIndexes = new LinkedList<Integer>();

	public void setArrayElements(String arrayElements) {
		this.arrayElements = arrayElements;
	}

	public String getArrayElements() {
		return arrayElements;
	}

	public void setQueries(String[] queries) {
		this.queries = queries;
	}

	public String[] getQueries() {
		return queries;
	}

	public void addColdNumberIndex(int index) {
		this.coldNumberIndexes.add(index);
	}

	public void addOldNumberIndex(int index) {
		this.oldNumberIndexes.add(index);
	}

	public int getColdNumberCount(int startIndex, int endIndex) {
		int count = 0;
		for(int index = startIndex; index <= endIndex; index++) {
			if(this.coldNumberIndexes.contains(index)) {
				count++;
			}
		}
		return count;
	}

	public int getOldNumberCount(int startIndex, int endIndex) {
		int count = 0;
		for(int index = startIndex; index <= endIndex; index++) {
			if(this.oldNumberIndexes.contains(index)) {
				count++;
			}
		}
		return count;
	}
}
