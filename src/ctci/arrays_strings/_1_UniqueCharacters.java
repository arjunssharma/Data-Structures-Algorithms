package ctci.arrays_strings;

public class _1_UniqueCharacters {
	
	public static void main(String args[]) {
		System.out.println(isUniqueCharacters("arjun"));
	}
	
	//Assuming ASCII String
	public static boolean isUniqueCharacters(String str) {
		if(str.length() > 128) 
			return false;
		
		boolean character[] = new boolean[128];
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if(character[ch]) {
				return false;
			}
			character[ch] = true;
		}
		return true;
	}
}