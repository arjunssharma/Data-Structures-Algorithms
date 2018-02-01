package ctci.arrays_strings;

import java.util.Arrays;

public class _3_URLify {

	public static void main(String args[]) {
		String s = "Mr John Smith    ";
		char str[] = s.toCharArray();
		replace(str, 13);
		System.out.println(Arrays.toString(str));
	}
	
	public static void replace(char str[], int length) {
		int countOfSpaces = 0;
		for (int i = 0; i < length; i++) {
			if (str[i] == ' ')
				countOfSpaces++;
		}
		
		int index = length + countOfSpaces * 2;
		if(length < str.length)
			str[length] = '\0';
		
		for(int i = length - 1; i >= 0; i--) {
			if(str[i] == ' ') {
				str[index - 1]  = '0';
				str[index - 2]  = '2';
				str[index - 3]  = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
	}
}
