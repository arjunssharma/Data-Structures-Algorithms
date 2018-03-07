package ctci.arrays_strings;

public class _6_StringCompression {

	
	public static void main(String args[]) {
		String s = "aabcc";
		System.out.println(compress(s));
	}
	
	public static String compress(String s) {
		StringBuilder compress = new StringBuilder();
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			count++;
			if(i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
				compress.append(s.charAt(i));
				if(count > 1) 
					compress.append(count);
				count = 0;
			}
		}
		
		return compress.toString();
	}
}
