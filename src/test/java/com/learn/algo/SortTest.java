package com.learn.algo;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;


public class SortTest {
	
	private int[] unsortedArray = {6, 7, 9, 2, 5, 20, 51, 10};
	private int[] sortedArray = {2, 5, 6, 7, 9, 10, 20, 51};
	
	@Test
	public void testBubbleSort() {
		int[] resultArray = new BubbleSort().doSort(unsortedArray);
		assertArrayEquals(sortedArray, resultArray);
	}
	
	@Test
	public void testSelectionSort() {
		int[] resultArray = new SelectionSort().doSort(unsortedArray);
		assertArrayEquals(sortedArray, resultArray);
	}

	
}
