package per.tj.sort;

public class Insert_Sort {
	
	public static int[] insertSort(int[] input) {
		System.out.println("Initiating Insert Sort...");
		
		for(int i = 1; i < input.length; i++) {
			int key = input[i];
			int j = i - 1;
			while(j >= 0 && input[j] > key) {
				input[j+1] = input[j];
				j--;
			}
			input[j+1] = key;
		}
		
		return input;
	}
	
	public static void main(String[] args) {
		int[] input = Utils.RandomIntegers(10, 100);
		System.out.print("Input Integers: ");
		for(int i:input)
			System.out.print(i + "\t");
		System.out.println("");
		
		int[] output = Insert_Sort.insertSort(input);
		System.out.print("Output Integers: ");
		for(int i:output)
			System.out.print(i + "\t");
		System.out.println("");
	}
}
