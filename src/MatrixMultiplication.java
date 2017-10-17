import java.util.Arrays;

/*
 * a non-recursive algorithm which computes A^n, there A is a square matrix with integer coefficients 
 * achieved in at most 2*ceiling(lg(n)) matrix multiplication steps
 */

/**
 * @author arjunssharma1992
 */

public class MatrixMultiplication {
	public static int counter = 0;

	public static int[][] Call_multiplier(int[][] matrix, int power) {
		// 1 <= power <= 100
		int[][] last = new int[matrix.length][matrix.length];
		initializeResultantArray(last);
		if (power == 1) {
			return matrix;
		}
		while (power >= 1) {
			if (power % 2 == 0) { // when the power is even
				matrix = Multiply_matrices(matrix, matrix);
				power = power / 2;
			} else { // when the power is odd
				last = Multiply_matrices(last, matrix);
				power = power - 1;
			}
		}
		return last;
	}

	public static void initializeResultantArray(int last[][]) {
		for (int i = 0; i < last.length; i++) {
			for (int j = 0; j < last[i].length; j++) {
				if (i == j)
					last[i][j] = 1;
			}
		}
	}

	public static int[][] Multiply_matrices(int[][] a, int[][] b) {
		counter += 1;
		int rowsInA = a.length;
		int columnsInA = a[0].length; // same as rows in B
		int columnsInB = b[0].length;
		int[][] c = new int[rowsInA][columnsInB];
		for (int i = 0; i < rowsInA; i++) {
			for (int j = 0; j < columnsInB; j++) {
				for (int k = 0; k < columnsInA; k++) {
					c[i][j] = c[i][j] + a[i][k] * b[k][j];
				}
			}
		}
		return c;
	}

	public static void main(String args[]) {
		int[][] matrix = { { 1, 2, 3 }, { 3, 1, 2 }, { 2, 3, 1 } };
		int power = 8;
		int[][] result = Call_multiplier(matrix, power);
		System.out.println("Number of Multiplication Steps: " + counter);
		for (int i = 0; i < result.length; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}
}