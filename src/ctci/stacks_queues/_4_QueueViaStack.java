package ctci.stacks_queues;

import java.util.*;

public class _4_QueueViaStack {

	
	
}

class MyQueue {
	
	Stack<Integer> stackNewest;
	Stack<Integer> stackOldest;
	
	public int size() {
		return stackNewest.size() + stackOldest.size();
	}
	
	public void add(int x) {
		stackNewest.push(x);
	}
	
	private void shiftStacks() {
		if(stackOldest.isEmpty()) {
			while(!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	
	public int peek() {
		shiftStacks();
		return stackOldest.peek();
	}
	
	public int remove() {
		shiftStacks();
		return stackOldest.pop();
	}
}