// Author @Brendan Han
// Coding Assignment 03
// CSE374

import java.util.*;

public class Solution {
	public int[][] sort(int[] list) { 
		int[][] arr = new int[2][2];
		
		// First uses the quickSort algorithm to sort the list array
		quickSort(list, 0, list.length - 1);
		arr[0] = list;
		
		// The list array is stored as a new array called sorted which will 
		// then be reversed using the reverse method
		int[] sorted = list;
		arr[1] = reverse(sorted);

		return arr;
	}
	
	/**
	 * The quickSort method that recursively calls the partition method
	 * if the array still needs to be sorted
	 * @param arr the array that is getting sorted
	 * @param left the left index of the array
	 * @param right the right index of the array
	 */
	public void quickSort(int[] arr, int left, int right) {
	    if (left < right) {
	        int partitionIndex = partition(arr, left, right);

	        quickSort(arr, left, partitionIndex - 1);
	        quickSort(arr, partitionIndex+1, right);
	    }
	}
	
	/**
	 * The helper method to the quickSort method above.
	 * Responsible to the partition phase of the algorithm
	 * @param arr
	 * @param left
	 * @param right
	 * @return The final sorted position of the pivot
	 */
	private int partition(int[] arr, int left, int right) {
	    int pivot = arr[right];
	    int i = (left - 1);

	    for (int j = left; j < right; j++) {
	        if (arr[j] <= pivot) {
	            i++;

	            int temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	        }
	    }

	    int temp = arr[i + 1];
	    arr[i + 1] = arr[right];
	    arr[right] = temp;

	    return i + 1;
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
