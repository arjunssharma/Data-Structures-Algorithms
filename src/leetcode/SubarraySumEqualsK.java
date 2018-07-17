package leetcode;

import java.util.*;

public class SubarraySumEqualsK {

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int target = 5;
		System.out.println(subarraySum(arr, target));
	}

	public static int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;
		int counter = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k))
				counter += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return counter;
	}
}
