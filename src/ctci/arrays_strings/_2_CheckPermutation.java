package ctci.arrays_strings;

import java.util.Arrays;

public class _2_CheckPermutation {

	public static void main(String args[]) {
		System.out.println(isPermutation("ARJUN", "NUJRA"));
	}
	
	public static boolean isPermutation(String s, String t) {
		if(s.length() != t.length()) 
			return false;

		return sort(s).equals(sort(t));
	}
	
	public static String sort(String str){
		char ch[] = str.toCharArray();
		Arrays.sort(ch);
		String sortedString = new String(ch);
		return sortedString;
	}
}
