package ctci.stacks_queues;

import java.util.Stack;

public class _5_SortStack {

	public static void main(String args[]) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(10);
		s.push(15);
		s.push(5);
		s.push(2);
		s.push(3);
		s.push(0);
		Stack<Integer> result = sortStack(s);
		while(!result.isEmpty()) {
			System.out.print(result.pop() + " ");
		}
	}
	
	public static Stack<Integer> sortStack(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while (!s.empty()) {
			int temp = s.pop();
			while(!r.isEmpty() && r.peek() > temp) {
				s.push(r.pop());
			}
			r.push(temp);
		}
		
		while(!r.isEmpty()) {
			s.push(r.pop());
		}
		
		return s;
	}
}
