import java.util.Arrays;
/**
 * @author arjunssharma1992
 */
public class BubbleSort {
	public static void main(String argsd[]) {
		int a[] = new int[]{7,6,9,5};
		int noOfComparisons = 0;
		int noOfPasses = 0;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = a.length - 1; j > i; j--) {
				noOfPasses++;
				if (a[j] < a[j - 1]) {
					noOfComparisons++;
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}
		System.out.println("No of passes " + noOfPasses);
		System.out.println("No of Comparisons " + noOfComparisons);
		System.out.println(Arrays.toString(a));
	}
}
