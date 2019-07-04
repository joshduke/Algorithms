package com.learn.algo.problems;

import java.util.Scanner;

public class StringRotation {

	public static void main(String args[] ) throws Exception {
		//Scanner
		Scanner s = new Scanner(System.in);
		int N = Integer.parseInt(s.nextLine());
		String S = s.nextLine();
		String T = s.nextLine();
		System.out.println(new StringRotation().rotateString(S, T, N));
	}

	private int rotateString(String rotateString, String targetString, int N) {
		if(N > 1) {
			if(targetString.equals(rotateString)) {
				return 0;
			}else {
				int counter = 1;
				while(true) {
					if(targetString.substring(0, targetString.length()-(counter)).equals(rotateString.substring(counter))) {
						return counter;
					}
					counter++;
					if(counter > N) {
						return N;
					}
				}
			}
		}else {
			if(targetString.equals(rotateString)) {
				return 0;
			}else {
				return 1;
			}
		}
	}

}
