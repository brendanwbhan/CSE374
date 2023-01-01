// Author @Brendan Han
// Coding Assignment 03
// CSE374

import java.util.*;

public class Solution {
	public int[][] mergeSort(int[] list) {
		int[][] arr = new int[2][2];
		
		// First uses the mergeSort algorithm to sort the list array
		mergeSort(list, list.length);
		arr[0] = list;
		
		// The list array is stored as a new array called sorted which will 
		// then be reversed using the reverse method
		int[] sorted = list;
		arr[1] = reverse(sorted);

		return arr;
	}
	
	/**
	 * This is a method that will recursively divide the original array
	 * into two sub arrays: the divide phase.
	 * @param arr the array that needs to be merge sorted
	 * @param length the length of the array arr
	 */
	public void mergeSort(int[] arr, int length) {
		
		// The base case, if the length is less than 2
		// The array is already sorted
		if (arr.length < 2) {
	        return;
	    }
		
		// Finding the mid point
	    int mid = length / 2;
	    int[] left = new int[mid];
	    int[] right = new int[length - mid];

	    // Splitting the array arr into two temporary sub arrays
	    // The left sub array is from 0 - mid-1
	    // The right sub array is from mid to arry.length-1
	    for (int i = 0; i < mid; i++) {
	        left[i] = arr[i];
	    }
	    
	    for (int i = mid; i < length; i++) {
	        right[i - mid] = arr[i];
	    }
	    
	    // We recursively call the mergeSort method again with new lengths
	    mergeSort(left, mid);
	    mergeSort(right, length - mid);

	    // We call the merge method to merge the sub arrays together
	    merge(arr, left, right, mid, length - mid);
	}
	
	/**
	 * This is a method that will take the divide subarrays as a parameter
	 * and sort and merge them back together: the conquer phase
	 * @param arr the array that we want to merge
	 * @param l the temporary left array of array arr 
	 * @param r the temporary right array of the array arr
	 * @param left the left bound
	 * @param right the right bound
	 */
	public void merge(int[] arr, int[] l, int[] r, int left, int right) {
		int i = 0, j = 0, k = 0;
	    
		while (i < left && j < right) {
			if (l[i] <= r[j]) arr[k++] = l[i++];
	        else arr[k++] = r[j++];
	    }
		
	    while (i < left) {
	    	arr[k++] = l[i++];
	    }
	    
	    while (j < right) {
	    	arr[k++] = r[j++];
	    }
	}
	
	/**
	 * This is a method that will reverse a given array
	 * @param arr the array that needs to be reversed
	 * @return the reversed array of arr
	 */
	public int[] reverse(int[] arr) {
		int[] ret = new int[arr.length];
		
		// Loop through the original array and store values 
		// in the new array starting from the back
		for (int i = 0; i < arr.length; i++) {
			ret[i] = arr[arr.length - i - 1];
		}
		
		return ret;
	}
}