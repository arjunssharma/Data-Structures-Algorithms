package ctci.arrays_strings;

public class _4_PalindromePermutation {

	public static void main(String args[]) {
		System.out.println(canPermutePalindrome("ARJJAR"));
	}

	public static boolean canPermutePalindrome(String str) {
		// Assuming ASCII
		int map[] = new int[128];
		for (int i = 0; i < str.length(); i++) {
			map[str.charAt(i)]++;
		}

		int count = 0;
		for (int i = 0; i < map.length && count <= 1; i++) {
			count += map[i] % 2;
		}

		return count <= 1;
	}
}
