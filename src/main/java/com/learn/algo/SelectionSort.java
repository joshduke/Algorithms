package com.learn.algo;

import java.util.Arrays;

public class SelectionSort {

	public int[] doSort(int[] inputArray) {
		int minValueIndex = 0, temp;
		for(int i=0; i<inputArray.length; i++) {
			minValueIndex = findMinValueIndex(Arrays.copyOfRange(inputArray, i, inputArray.length)) + i;
			if(minValueIndex != i) {
				temp = inputArray[minValueIndex];
				inputArray[minValueIndex] = inputArray[i];
				inputArray[i] = temp;
			}
			System.out.println(Arrays.toString(inputArray));
		}
		return inputArray;
	}

	public int findMinValueIndex(int[] inputArray) {
		int minValueIndex=0;
		for(int j=1; j<inputArray.length; j++) {
			if(inputArray[minValueIndex]>inputArray[j]) {
				minValueIndex = j;
			}
		}
		return minValueIndex;
	}

	public static void main(String[] args) {
		int[] array = {3,7,2,4,8,9,1,0,6};
//		System.out.println(Arrays.toString(new SelectionSort().doSort(array)));
		new SelectionSort().doSort(array);
	}
}
