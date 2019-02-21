import java.util.Arrays;

public class BinaryInsertionSort {
	
	public static void main(String args[]) {
		int nums[] = {3, 1, 2, 0, 4, 6};
		binaryInsertionSort(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	public static void binaryInsertionSort(int nums[]) {
		for(int i = 1; i < nums.length; i++) {
			int x = nums[i];
			int j = Math.abs(Arrays.binarySearch(nums, 0, i, x) + 1);
			System.arraycopy(nums, j, nums, j + 1, i - j);
			nums[j] = x;
		}
	}
}
