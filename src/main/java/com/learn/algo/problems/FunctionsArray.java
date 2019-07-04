package com.learn.algo.problems;

import java.util.Scanner;

public class FunctionsArray {


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = Integer.parseInt(scanner.nextLine());
		int[] A = new int[N];
		for(int input=0; input < N; input++) {
			A[input] = Integer.parseInt(scanner.nextLine());
		}
		new FunctionsArray().getFunctionValues(A, N);
	}

	public void getFunctionValues(int[] A, int N) {
		int fx;
		int gx;
		for(int index = 0; index < N; index++) {
			fx = -1;
			gx = -1;
			fx = fOfx(A,N,index);
			if(fx != -1) {
				gx = gOfx(A, N, fx);
			}
			if(gx != -1) {
				System.out.print(A[gx] + " ");
			}else {
				System.out.print(-1 + " ");
			}
		}
	}

	public int fOfx(int[] A, int N, int index) {
		for(int i = 0; i < N; i++) {
			if(A[index] < A[i] && index < i) {
				return i;
			}
		}
		return -1;
	}

	public int gOfx(int[] A, int N, int index) {
		for(int i = 0; i < N; i++) {
			if(A[index] > A[i] && index < i) {
				return i;
			}
		}
		return -1;
	}

}
