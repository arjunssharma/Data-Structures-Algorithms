package linkedIn;

public class ShiftingStrings {

	public static String getShiftedString(String s, int leftShifts, int rightShifts) {
		char[] ch = s.toCharArray();
		char[] result = new char[ch.length];
		int d = Math.abs(leftShifts - rightShifts);
		d = d % ch.length;
		int position = 0;

		if (leftShifts == rightShifts)
			return s;
		else if (leftShifts < rightShifts)
			for (int i = 0; i < ch.length; i++)
				result[(i + d) % ch.length] = ch[i];
		else if (leftShifts > rightShifts) {
			for (int i = 0; i < ch.length; i++) {
				position = (i - d) % ch.length;
				if (i < d)
					position = ch.length - d + i;
				else
					position = i - d;
				result[position] = ch[i];
			}
		}

		return String.valueOf(result);
	}
}
