
public class StringSubsequence {

	public boolean recursiveIsSubsequence(String s1, String s2, int m, int n) {
		// Base Cases
        if (m == 0) 
            return true;
        if (n == 0) 
            return false;
             
        // If last characters of two strings are matching
        if (s1.charAt(m-1) == s2.charAt(n-1))
            return recursiveIsSubsequence(s1, s2, m-1, n-1);
 
        // If last characters are not matching
        return recursiveIsSubsequence(s1, s2, m, n-1);
	}
	
	
	public boolean iterativeIsSubsequence(String s1, String s2, int m, int n) {
		 int j = 0;
         
	        // Traverse s2 and s1, and compare current character 
	        // of s2 with first unmatched char of s1, if matched 
	        // then move ahead in s1
	        for (int i=0; i<n&&j<m; i++)
	            if (s1.charAt(j) == s2.charAt(i))
	                j++;
	 
	        // If all characters of s1 were found in s2
	        return (j==m);
	}
}
