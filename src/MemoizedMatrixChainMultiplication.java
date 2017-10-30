/**
 * @author arjunssharma1992
 */
public class MemoizedMatrixChainMultiplication {

	static int countOfScalarMultiplications = 0;
	
	public static void main(String args[]) {
		int p[] = {5, 2, 7, 7, 9, 4, 7, 11, 13, 1, 4, 7, 2, 3, 5, 7, 9};
		long startTime = System.nanoTime();
		System.out.println("Minimum Number of Scalar Multiplications is: " + memoized_matrix_chain(p));
		long endTime   = System.nanoTime();
		System.out.println("Total time required by Memoized Algorithm is: " + (endTime - startTime) + " nano seconds");
		System.out.println("Number of Scalar Multiplications Performed are: " + countOfScalarMultiplications);
	}

	public static int memoized_matrix_chain(int p[]) {
		int n = p.length - 1;
		int min[][] = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				min[i][j] = Integer.MAX_VALUE;
			}
		}

		return lookup_chain(min, p, 1, n);
	}

	public static int lookup_chain(int min[][], int p[], int i, int j) {
		int q;
		if (min[i][j] < Integer.MAX_VALUE) {
			return min[i][j];
		}

		if (i == j) {
			min[i][j] = 0;
		} else {
			for (int k = i; k < j; k++) {
				countOfScalarMultiplications+=2;
				q = lookup_chain(min, p, i, k) + lookup_chain(min, p, k + 1, j) + p[i - 1] * p[k] * p[j];
				if (q < min[i][j]) {
					min[i][j] = q;
				}
			}
		}

		return min[i][j];
	}
}
