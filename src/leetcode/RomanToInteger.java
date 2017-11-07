package leetcode;

import java.util.HashMap;

public class RomanToInteger {

	public int romanToInt(String s) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			int first = map.get(Character.toString(s.charAt(i)));
			if (i + 1 < s.length()) {
				int second = map.get(Character.toString(s.charAt(i + 1)));
				if (first >= second)
					result += first;
				else {
					result += second - first;
					i++;
				}
			} else {
				result += first;
			}
		}
		return result;
	}
}
