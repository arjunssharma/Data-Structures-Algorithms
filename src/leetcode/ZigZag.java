package leetcode;

public class ZigZag {

	public String convert(String s, int numRows) {
		if (numRows < 1)
			return null;
		else if (numRows == 1)
			return s;

		StringBuilder sb[] = new StringBuilder[numRows];
		for (int i = 0; i < sb.length; i++) {
			sb[i] = new StringBuilder("");
		}

		int counter = 1;
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			sb[index].append(s.charAt(i));
			if (index == 0)
				counter = 1;
			if (index == numRows - 1)
				counter = -1;
			index += counter;
		}

		String result = new String();
		for (int i = 0; i < sb.length; i++)
			result += sb[i];

		return result;
	}
}