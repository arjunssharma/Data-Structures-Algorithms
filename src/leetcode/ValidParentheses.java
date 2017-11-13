package leetcode;

import java.util.Stack;

public class ValidParentheses {
	
	public static void main(String args[]) {
		System.out.println(isValid("[]{})"));
	}
	
	public static boolean isValid(String s) {
        if(s == null) {
            return true;
        }
        else {
            Stack<Character> stack = new Stack<Character>();
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[')
                    stack.push(s.charAt(i));
                else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
                    stack.pop();
                else if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
                    stack.pop();
                else if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
                    stack.pop();
                else
                    return false; 
            }
            return stack.isEmpty();
        }
    }
}
