/**
 * @author arjunssharma1992
 */
public class RecursiveMatrixChainMultiplication {

	static int countOfScalarMultiplications = 0;
	
	public static void main(String args[]) {
		int p[] = {5, 2, 7, 7, 9, 4, 7, 11, 13, 1, 4, 7, 2, 3, 5, 7, 9};
		int n = p.length;
		long startTime = System.nanoTime();
		System.out.println("Minimum Number of Scalar Multiplications is: " + recursive_matrix_chain(p, 1, n - 1));
		long endTime   = System.nanoTime();
		System.out.println("Total time required by recursive algorithm is: " + (endTime - startTime) + " nano seconds");
		System.out.println("Number of Scalar Multiplications Performed are: " + countOfScalarMultiplications);
	}

	public static int recursive_matrix_chain(int p[], int i, int j) {
		if (i == j)
			return 0;

		int minimum = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			countOfScalarMultiplications+=2;
			int count = recursive_matrix_chain(p, i, k) + recursive_matrix_chain(p, k + 1, j) + p[i - 1] * p[k] * p[j];
			if (minimum > count)
				minimum = count;
		}

		return minimum;
	}
}