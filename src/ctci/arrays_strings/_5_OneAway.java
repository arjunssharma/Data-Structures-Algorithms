package ctci.arrays_strings;

public class _5_OneAway {

	public static void main(String args[]) {
		System.out.println(checkEdit("bale", "baaes"));
	}

	public static boolean checkEdit(String s, String t) {
		if (s == null || t == null)
		    return false;
		
		if(Math.abs(s.length() - t.length()) > 1)
			return false;
		
		if (s.length() > t.length())
		    return checkEdit(t, s);
		      
		  int i = 0, j = 0;
		  //t should be the longer string
		  while (i < s.length() && j < t.length()) {
		    if (s.charAt(i) != t.charAt(j)) {
		      // we try to replace s[i] with s[j] or insert s[j] to s[i]
		      // then compare the rest and see if they are the same
		      return s.substring(i + 1).equals(t.substring(j + 1)) ||
		             s.substring(i).equals(t.substring(j + 1));
		    }
		    
		    i++; j++;
		  }
		  
		  return true;
	}
}
