package leetcode;

public class CountAndSay {

	public static void main(String args[]) {
		System.out.println(countAndSay(4));
	}
	
	public static String countAndSay(int n) {
		if(n == 0) 
			return "";
		if(n == 1)
			return "1";
		
		String s = countAndSay(n - 1);
		String res = "";
		for(int i = 0; i < s.length(); i++) {
			int count = 1;
			char temp = s.charAt(i);
			while(i + 1 < s.length() && s.charAt(i + 1) == temp) {
				count++;
				i++;
			}
			res = res + count + temp;
		}
		
		return res;
	}
}