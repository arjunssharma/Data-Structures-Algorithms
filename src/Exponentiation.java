/*
 * The below algorithm for computing a raised to power uses the method of squaring exponentiation.
 * asymptotic running time of the algorithm is θ(lg n)
 */

/**
 * @author arjunssharma1992
 */


public class Exponentiation {

	static int timeComplexity = 0;
	
	public static int computePower(int a, int n) {
		int result = 1;
		while (n > 0) {
			timeComplexity++;
			if (n % 2 == 1) //or n % 2 != 0 if n is odd
				result *= a;
			a *= a;
			n /= 2;
		}
		return result;
	}

	public static void main(String args[]) {
		System.out.println("2 raised to 5 is: " + computePower(2, 5));
		System.out.println("Time Complexity is: " + timeComplexity);
	}
}
