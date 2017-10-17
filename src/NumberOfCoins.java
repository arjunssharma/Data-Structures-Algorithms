/*
 * Recursive Algorithm to compute series of coins required for changing n cents
 * with denominations of 50, 25, 10, 5, and 1 cent
 */

/**
 * @author asharm33
 */

public class NumberOfCoins {

	public static void main(String args[]) {
		int totalAmount = 23;
		calculateNoOfCoins(totalAmount);
	}

	static int calculateNoOfCoins(int totalAmount) {
		int denominations[] = new int[] { 25, 50, 10, 5, 1 };
		if (totalAmount != 0) {
			int countOfDenomination;
			int remaining;
			for (int denomination : denominations) {
				countOfDenomination = totalAmount / denomination;
				if (countOfDenomination != 0) {
					remaining = totalAmount % denomination;
					System.out.println("No of coins of value " + denomination + " is " + countOfDenomination);
					return calculateNoOfCoins(remaining);
				}
			}
		}
		return 0;
	}	
}