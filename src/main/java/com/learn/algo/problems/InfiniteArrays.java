package com.learn.algo.problems;

public class InfiniteArrays {

	public static void main(String[] args) {
		String[] A = new String[] {"4", "1", "5"};
		String[] li = new String[] {"1", "3", "9"}; 
		String[] ri = new String[] {"4", "7", "10"};
		for(int i = 0; i < li.length; i++) {
			System.out.print(new InfiniteArrays().findSumofSubArray(A, A.length, Integer.parseInt(li[i]), Integer.parseInt(ri[i])));
		}
		//		System.out.println(new InfiniteArrays().sumofSubArray(A, 3, 2));
	}

	public int findSumofSubArray(String[] array, int arraySize, int leftIndex, int rightIndex) {
		int internalLeftIndex;
		int indexRange = rightIndex - leftIndex;
		if(leftIndex <= arraySize) {
			internalLeftIndex = leftIndex;
		}else {
			internalLeftIndex = leftIndex % arraySize;
			if(internalLeftIndex == 0) {
				internalLeftIndex = internalLeftIndex + arraySize;
			}
			
		}

		return sumofSubArray(array, internalLeftIndex,indexRange);
	}

	public int sumofSubArray(String[] array, int startIndex, int range) {
		int M = 1000000007;
		int N = array.length;
		int index = startIndex - 1;
		int sum = 0;
		int indexStep = 0;
		while(indexStep <= range) {
			for(; index < N; index++) {
				sum = sum + Integer.parseInt(array[index]);
				indexStep++;
				if(indexStep > range) {
					break;
				}
			}
			index=0;
		}
		return sum%M;
	}

}
