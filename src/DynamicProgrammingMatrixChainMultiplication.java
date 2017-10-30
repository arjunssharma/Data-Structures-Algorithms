
public class DynamicProgrammingMatrixChainMultiplication {

	static int countOfScalarMultiplications = 0;
	
	public static void main(String args[]) {
		int p[] = {5, 2, 7, 7, 9, 4, 7, 11, 13, 1, 4, 7, 2, 3, 5, 7, 9};
		long startTime = System.nanoTime();
		System.out.println("Minimum Number of Scalar Multiplications is: " + dynamic_matrix_chain(p));
		long endTime   = System.nanoTime();
		System.out.println("Total time required by dynamic programming is: " + (endTime - startTime) + " nano seconds");
		System.out.println("Number of Scalar Multiplications Performed are: " + countOfScalarMultiplications);
	}

	public static int dynamic_matrix_chain(int p[]) {
		int n = p.length;
		int min[][] = new int[n][n];
		int i, j, k, lengthOfChain, q;

		// We don't need 0th row and column
		for (i = 1; i < n; i++)
			min[i][i] = 0;

		for (lengthOfChain = 2; lengthOfChain < n; lengthOfChain++) {
			for (i = 1; i < n - lengthOfChain + 1; i++) {
				j = i + lengthOfChain - 1;
				if (j == n)
					continue;
				min[i][j] = Integer.MAX_VALUE;
				for (k = i; k <= j - 1; k++) {
					countOfScalarMultiplications+=2;
					q = min[i][k] + min[k + 1][j] + p[i - 1] * p[k] * p[j];
					if (q < min[i][j])
						min[i][j] = q;
				}
			}
		}

		return min[1][n - 1];
	}

}
