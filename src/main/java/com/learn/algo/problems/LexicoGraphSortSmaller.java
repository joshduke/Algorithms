package com.learn.algo.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LexicoGraphSortSmaller {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();                // Reading input from STDIN
		int N = Integer.parseInt(br.readLine());
		StringBuffer inputString = new StringBuffer(input);
		//		while(inputString.length() > 0) {

		StringBuffer newString = new StringBuffer();
		char[] charArray = inputString.toString().toCharArray();
		int[] asciiValues = new int[charArray.length];
		//		int[] lexicoGraphIndex = new int[charArray.length];
		//		char minChar = '0';
		int minCharIndex = -1;
		int minAsciiValue =  -1;
		/*for(int i = 0; (i < N && i < charArray.length); i++) {
				if(i == 0) {
					minChar = charArray[i];
					minCharIndex = i;
				}else {
					int minCharASCII = (int)minChar;
					int currentCharASCII = (int)charArray[i];
					if(minCharASCII > currentCharASCII) {
						minChar = charArray[i];
						minCharIndex = i;
					}
				}
			}
			if(minCharIndex >= 0) {
				inputString.delete(minCharIndex, minCharIndex+1);
				newString.append(minChar);
			}*/

		for(int i = 0; i < charArray.length; i++) {
			asciiValues[i] = (int)charArray[i];
		}
		int iterationCount = 0;
		while(inputString.length() > 0) {
			System.out.println(N + iterationCount);
			minAsciiValue = 1000;
			for(int j = 0; (j < (N + iterationCount) && j < inputString.length()); j++) {
				if(asciiValues[j] > 0 && asciiValues[j] < minAsciiValue) {
					minAsciiValue = asciiValues[j];
					minCharIndex = j;
				}
			}
			/*if(minCharIndex == 0) {
				asciiValues[0] = -1;
			}*/
			inputString.delete(minCharIndex, minCharIndex+1);
			asciiValues[minCharIndex] = -1;
			newString.append(charArray[minCharIndex]);
			System.out.println(newString.toString());
			iterationCount++;
		}

		System.out.print(newString.toString());
		//		}
	}

}