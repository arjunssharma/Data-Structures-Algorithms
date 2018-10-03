package linkedIn;

import java.util.Arrays;

public class DistinctPairs {

	static int numberOfPairs(int[] a, long k) {
		Arrays.sort(a);
		int n = a.length;
		int i = 0, j = n - 1;
		int count = 0;
		while (i < j) {
			while (i > 0 && a[i] == a[i - 1])
				i++; // skip duplicate
			while (j < n - 1 && a[j] == a[j + 1])
				j--; // skip duplicate
			long sum = a[i] + a[j];
			if (sum == k) {
				count++;
				i++;
				j--;
			} else if (sum < k)
				i++;
			else
				j--;
		}
		return count;
	}

	public static void main(String args[]) {
		int a[] = { 6, 12, 3, 9, 3, 5, 1 };
		System.out.println(numberOfPairs(a, 12));
	}
}
