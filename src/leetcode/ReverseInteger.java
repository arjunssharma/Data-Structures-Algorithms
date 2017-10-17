package leetcode;

/*
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * Note:
 * The input is assumed to be a 32-bit signed integer. 
 * Your function should return 0 when the reversed integer overflows.
 * 
 */

/**
 * @author arjunssharma1992
 */

class ReverseInteger {
    public static int reverse(int x) {
        String s = new Integer(x).toString();
        String result = new String();
        if(s.charAt(0) == '-'){
            result += "-";
            s = s.substring(1);
        }
        for(int i=s.length()-1;i >=0 ;i--) {
            result += s.charAt(i);
        }
        int finalAnswer;
        try {
            finalAnswer = Integer.parseInt(result);
        } catch(Exception e) {
            return 0;
        }
        
        return finalAnswer;
    }
    
    public static void main(String args[]) {
    	System.out.println(reverse(-32434));
    }
}