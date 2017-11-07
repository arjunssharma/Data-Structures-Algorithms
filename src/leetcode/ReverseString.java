package leetcode;
class ReverseString {
	//Time Complexity O(n)
    public String reverseString(String s) {
      String result = new String();
      for (int i = s.length() - 1; i >= 0; i--) {
          result += s.charAt(i);
      }
      return result;
    }
    
    public String reverseString1(String s) {
        StringBuffer result = new StringBuffer(s);
        result.reverse();
        return result.toString();
      }
}