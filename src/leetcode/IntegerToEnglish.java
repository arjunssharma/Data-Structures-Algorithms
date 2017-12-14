package leetcode;

public class IntegerToEnglish {

	private String[] LESS_THAN_10 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
	private String[] LESS_THAN_20 = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };
	private final String[] LESS_THAN_100 = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
			"Eighty", "Ninety" };

	public String convert(int n) {
		if (n == 0)
			return "Zero";

		return helper(n);
	}

	public String helper(int n) {
		String result = new String();
		if (n < 10)
			result = LESS_THAN_10[n];
		else if (n < 20)
			result = LESS_THAN_20[n - 10];
		else if (n < 100)
			result = LESS_THAN_100[n / 10] + " " + helper(n % 10);
		else if (n < 1000)
			result = helper(n / 100) + " Hundred " + helper(n % 100);
		else if (n < 1000000)
			result = helper(n / 1000) + " Thousand " + helper(n % 1000);
		else if (n < 1000000000)
			result = helper(n / 1000000) + " Million " + helper(n % 1000000);
		else
			result = helper(n / 1000000000) + " Billion " + helper(n % 1000000000);

		return result.trim();
	}
	
	
	public static void main(String args[]) {
		System.out.println(new IntegerToEnglish().convert(10000001));
	}
}
