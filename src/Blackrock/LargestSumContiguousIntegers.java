package Blackrock;

public class LargestSumContiguousIntegers {

	public static void main(String[] args) {
		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("Maximum contiguous sum is " + largestContiguousSubArraySum(a));
	}

	public static int largestContiguousSubArraySum(int a[]) {
		int largestFinalAnswer = a[0]; 
		int largestIntermediateAnswer = a[0];

		for (int i = 1; i < a.length; i++) {
			largestIntermediateAnswer = Math.max(a[i], largestIntermediateAnswer + a[i]);
			largestFinalAnswer = Math.max(largestFinalAnswer, largestIntermediateAnswer);
		}
		return largestFinalAnswer;
	}
}