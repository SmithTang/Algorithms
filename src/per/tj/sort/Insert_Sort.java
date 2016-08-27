package per.tj.sort;

/**
 * @Time 2016-8-27 21:53:56
 * @version 1.0
 * @author Coder_T
 *
 */
public class Insert_Sort {
	
	/**
	 * Type of sort, ascending and descending
	 * @author Coder_T
	 *
	 */
	enum SortType{ASCENDING, DESCENDING};
	
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
	
	public static void main(String[] args) {
		int[] input = Utils.RandomIntegers(10, 100);
		System.out.print("Input Integers: ");
		for(int i:input)
			System.out.print(i + "\t");
		System.out.println("");
		
		int[] output = Insert_Sort.insertSort(input, SortType.DESCENDING);
		
		System.out.print("Output Integers: ");
		for(int i:output)
			System.out.print(i + "\t");
		System.out.println("");
	}
}
