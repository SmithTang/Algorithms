package per.tj.sort;

import java.util.Scanner;

/**
 * @Time 2016-8-27 21:53:56
 * @version 1.0
 * @author Coder_T
 *
 */
public class Sort {
	
	/**
	 * Type of sort, ascending and descending
	 * @author Coder_T
	 *
	 */
	public static enum SortType{ASCENDING, DESCENDING};
	
	private static final int TRESHOLD_VALUE = 20;
	
	//lock constructor, inhibit intantiation
	private Sort() {}
	
	/**
	 * @param distorted int[]
	 * @return new sorted int[]
	 */
	public static int[] insertSort(int[] input, SortType type) {
		System.out.println("Initiating Insert Sort...");
		
		int[] output = input.clone();
		
		System.out.println("Clone completed, sorting...");
		int swapCount = 0;
		if(type == SortType.ASCENDING)
			for(int i = 1; i < output.length; i++) {
				int key = output[i];
				int j = i - 1;
				while(j >= 0 && output[j] > key) {
					output[j+1] = output[j];
					j--;
					swapCount++;
					if(swapCount == Integer.MAX_VALUE) {
						System.out.println("Warning! swap count beyond Integer.Max_Value!");
						System.exit(0);
					}
				}
				output[j+1] = key;
			}
		else if(type == SortType.DESCENDING)
			for(int i = 1; i < output.length; i++) {
				int key = output[i];
				int j = i - 1;
				while(j >= 0 && output[j] < key) {
					output[j+1] = output[j];
					j--;
					swapCount++;
					if(swapCount == Integer.MAX_VALUE) {
						System.out.println("Warning! swap count beyond Integer.Max_Value!");
						System.exit(0);
					}
				}
				output[j+1] = key;
			}
		System.out.println("Sort completed: ");
		System.out.println("totally swaped " + swapCount + " times.");
		return output;
	}
	
	/**
	 * @param distorted int[]
	 * @return new sorted int[]
	 */
	public static int[] bubbleSort(int[] input, SortType type) {
		System.out.println("Initiating Bubble Sort...");
		
		int[] output = input.clone();
		
		System.out.println("Clone completed, sorting...");
		int swapCount = 0;
		if(type == SortType.ASCENDING)
			for(int i = 0; i < output.length; i++) {
				for(int j = output.length - 1; j > i; j--) {
					if(output[j - 1] > output[j]) {
						swap(output, j - 1, j);
						swapCount++;
					}
					if(swapCount == Integer.MAX_VALUE) {
						System.out.println("Warning! swap count beyond Integer.Max_Value!");
						System.exit(0);
					}
				}
			}
		else if(type == SortType.DESCENDING)
			for(int i = 0; i < output.length; i++) {
				for(int j = output.length - 1; j > i; j--) {
					if(output[j - 1] < output[j]) {
						swap(output, j - 1, j);
						swapCount++;
					}
					if(swapCount == Integer.MAX_VALUE) {
						System.out.println("Warning! swap count beyond Integer.Max_Value!");
						System.exit(0);
					}
				}
			}
		System.out.println("Sort completed: ");
		System.out.println("totally swaped " + swapCount + " times.");
		return output;
	}
	
	
	/**
	 * @param distorted int[]
	 * @return new sorted int[]
	 */
	public static int[] selectSort(int[] input, SortType type) {
		System.out.println("Initiating Select Sort...");
		
		int[] output = input.clone();
		
		System.out.println("Clone completed, sorting...");
		int selectCount = 0;
		int swapCount = 0;
		if(type == SortType.ASCENDING)
			for(int i = 0; i < output.length - 1; i++) {
				int min = i;
				for(int j = i; j < output.length; j++) {
					if(output[j] < output[min]) {
						min = j;
						selectCount++;
					}
				}
				swap(output, i, min);
				swapCount++;
			}
		else if(type == SortType.DESCENDING)
			for(int i = 0; i < output.length - 1; i++) {
				int max = i;
				for(int j = i; j < output.length; j++) {
					if(output[j] > output[max]) {
						max = j;
						selectCount++;
					}
				}
				swap(output, i, max);
				swapCount++;
			}
		System.out.println("Sort completed: ");
		System.out.println("totally selected " + selectCount + " times.");
		System.out.println("totally swaped " + swapCount + " times.");
		return output;
	}
	
	/**
	 * subsidiary swap method<br>
	 * left and right can be exchanged
	 * @param array target array
	 * @param left
	 * @param right
	 */
	public static void swap(int[] array, int left, int right) {
		if(array.length == 0) return;
		if(left < 0 || left > array.length || right < 0 || right > array.length ) return;
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	/**
	 * @param input distorted int[]
	 * @param truncation between 0~length
	 * @return int[] new sorted int[]
	 */
	public static int[] mergeSort(int[] input, int truncation, SortType type) {
		int[] output = input.clone();
		int leftLength = 0, rightLength = 0;
		
		if(truncation < 0) {
			System.out.println("Truncation can't lower than 0!\nSort failed!");
			return output;
		}
		else if(truncation == 0) {
			leftLength = output.length/2;
			rightLength = output.length - output.length/2;
		}
		else {
			if(truncation > output.length) {
				System.out.println("Truncation can't bigger than length!\nSort failed!");
				return output;
			}
			leftLength = truncation;
			rightLength = output.length - truncation;
		}
		int[] L = new int[leftLength + 1];
		int[] R = new int[rightLength + 1];
		
		for(int i = 0; i < leftLength; i++)
			L[i] = output[i];
		for(int i = 0; i < rightLength; i++)
			R[i] = output[i + leftLength];
		
		if(type == SortType.ASCENDING) {
			L[leftLength] = Integer.MAX_VALUE;
			R[rightLength] = Integer.MAX_VALUE;
		}
		else if(type == SortType.DESCENDING) {
			L[leftLength] = Integer.MIN_VALUE;
			R[rightLength] = Integer.MIN_VALUE;
		}
		
		//handle left
		if(leftLength > TRESHOLD_VALUE) {
			L = mergeSort(L, truncation, type);
		}
		else {
			L = selectSort(L, type);
		}
		
		//handle right
		if(rightLength > TRESHOLD_VALUE) {
			R = mergeSort(R, truncation, type);
		}
		else {
			R = selectSort(R, type);
		}
		
		//merge
		int i = 0, j = 0, k = 0;
		if(type == SortType.ASCENDING)
			for(; k < output.length; k++) {
				if(L[i] <= R[j]) {
					output[k] = L[i];
					i++;
				}
				else{
					output[k] = R[j];
					j++;
				}
			}
		else if(type == SortType.DESCENDING)
			for(; k < output.length; k++) {
				if(L[i] > R[j]) {
					output[k] = L[i];
					i++;
				}
				else{
					output[k] = R[j];
					j++;
				}
			}
		
		return output;
	}
	
	public static void main(String[] args) {
		int[] input = Utils.RandomIntegers(20, 100);
		System.out.print("Input Integers: ");
		for(int i:input)
			System.out.print(i + "\t");
		System.out.println("");
		
		int[] output = Sort.mergeSort(input, 0, Sort.SortType.ASCENDING);
		
		System.out.print("Output Integers: ");
		for(int i:output)
			System.out.print(i + "\t");
		System.out.println("");
		
		int target;
		target = new Scanner(System.in).nextInt();
		
		System.out.println("Find: " + BinarySearch.binarySearch(output, target));
	}
}
