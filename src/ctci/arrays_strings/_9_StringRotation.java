package ctci.arrays_strings;

public class _9_StringRotation {

	public static void main(String args[]) {
		System.out.println(rotation("Arjun", "rjunA"));
	}
	
	public static boolean rotation(String s1, String s2) {
		int length = s1.length();
		
		if(length == s2.length() && length > 0) {
			String doubleS1 = s1 + s1;
			return doubleS1.contains(s2);
		}
		return false;
	}
	
}
