package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {

	public static void main(String args[]) {
		System.out.println(reverseVowels("hello"));
	}
	
	public static String reverseVowels(String s) {
        Set<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        
        StringBuilder sb = new StringBuilder(s);
        
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if(set.contains(sb.charAt(i)) && set.contains(sb.charAt(j))) {
                char l = sb.charAt(i);
                char r = sb.charAt(j);
                sb.setCharAt(i, r);
                sb.setCharAt(j, l);
                i++;
                j--;
            } else if (set.contains(sb.charAt(i)) && !set.contains(sb.charAt(j)))
                j--;
              else if (!set.contains(sb.charAt(i)) && set.contains(sb.charAt(j)))
                i++;       
              else {
                  i++;
                  j--;
              }
        }
        return sb.toString();
    }
}
