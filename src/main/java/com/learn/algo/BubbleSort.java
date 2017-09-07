package com.learn.algo;

import java.util.Arrays;

public class BubbleSort {

	public int[] doSort(int[] inputArray) {
		int temp, iterationCount = 0;
		do {
			for(int i=0; i<((inputArray.length-1)-iterationCount); i++) {
				if(inputArray[i]>inputArray[i+1]) {
					temp = inputArray[i];
					inputArray[i] = inputArray[i+1];
					inputArray[i+1] = temp;
				}
			}
			iterationCount++;
		}while(iterationCount < (inputArray.length-1));
		return inputArray;
	}


	public static void main(String[] args) {
		int[] array = {3,7,2,4,8,9,1,0,6};
		System.out.println(Arrays.toString(new BubbleSort().doSort(array)));
	}
}
