package per.tj.sort;

public class BinarySearch {
	
	public static int binarySearch(int[] input, int target) {
		int l = -1;
		int r = input.length;
		while(l != r) {
			int mid = (l+r)>>1;
			int result = target - input[mid];
			if(result < 0) r = mid;
			else if(result == 0) return mid;
			else l = mid;
		}
		return -1;
	}
}
