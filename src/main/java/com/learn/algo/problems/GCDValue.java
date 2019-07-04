package com.learn.algo.problems;

import java.util.Scanner;

public class GCDValue {


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String N_K_String = scanner.nextLine();
		String A_String = scanner.nextLine();
		String[] N_K = N_K_String.split(" ");
		String A_ARY[] = A_String.split(" ");
		int[] A = new int[A_ARY.length];
		for(int i = 0; i < A_ARY.length; i++) {
			A[i] = Integer.parseInt(A_ARY[i]);
		}
		new GCDValue().findMaxSubSequenceValue(A, Integer.parseInt(N_K[1]));
	}

	public void findMaxSubSequenceValue(int[] A, int K) {
		int maxVal = A[0]^K;
		for(int index = 0; index < A.length; index++) {
			int value = maxVal ^ (A[index] ^ K);
			if(value < maxVal) {
				break;
			}else {
				maxVal = value;
			}
		}
		int gcd = findGCD(A);
		System.out.println(gcd*maxVal);
	}

	public int findGCD(int[] A) {
		int result = A[0];
		for(int index = 1; index < A.length; index++) {
			result = gcd(result,A[index]);
		}
		return result;
	}

	public static int gcd(int a, int b) 
	{ 
		if (a == 0) 
			return b; 

		return gcd(b%a, a); 
	}

}
