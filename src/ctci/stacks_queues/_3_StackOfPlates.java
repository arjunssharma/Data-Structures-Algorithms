package ctci.stacks_queues;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class _3_StackOfPlates {

	ArrayList<Stack> stacks = new ArrayList<Stack>();
	private static int CAPACITY;

	public _3_StackOfPlates(int capacity) {
		CAPACITY = capacity;
	}

	public void push(int x) {
		Stack last = getLastStack();
		if (last != null && !last.isFull()) {
			last.push(x);
		} else {
			Stack stack = new Stack(CAPACITY);
			stack.push(x);
			stacks.add(stack);
		}
	}

	public int pop() {
		Stack last = getLastStack();
		if (last != null) {
			int v = last.pop();
			if (last.isEmpty()) { // last.size() == 0
				stacks.remove(stacks.size() - 1);
			}
			return v;
		} else {
			throw new EmptyStackException();
		}
	}

	public int popAt(int index) {
		return leftShift(index, true);
	}

	public int leftShift(int index, boolean removeTop) {
		Stack s = stacks.get(index);
		int removed_item;
		if (removeTop) {
			removed_item = s.pop();
		} else {
			removed_item = s.removeBottom();
		}

		if (s.isEmpty()) {
			stacks.remove(index);
		} else if (stacks.size() > index + 1) {
			int v = leftShift(index + 1, false);
			s.push(v);
		}
		return removed_item;
	}

	public Stack getLastStack() {
		if (!stacks.isEmpty() && stacks != null) {
			return stacks.get(stacks.size() - 1);
		} else {
			return null;
		}
	}

	private class Stack {

		Node top;
		Node bottom;
		int capacity;
		int size = 0;

		public Stack(int capacity) {
			this.capacity = capacity;
		}

		public boolean isFull() {
			return capacity == size;
		}

		public void join(Node above, Node below) {
			if (below != null)
				below.above = above;

			if (above != null)
				above.below = below;
		}

		public boolean push(int x) {
			if (capacity <= size) {
				return false;
			}
			size++;
			Node n = new Node(x);
			if (size == 1) {
				bottom = n;
			}
			join(n, top);
			top = n;
			return true;
		}

		public int peek() {
			return top.data;
		}

		public int pop() {
			Node n = top;
			top = top.below; // And after this we can make n.below = null and
								// top.above = null
			size--;
			return n.data;
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public int removeBottom() {
			Node b = bottom;
			if (bottom != null)
				bottom = bottom.above;
			bottom.below = null;
			size--;
			return b.data;
		}
	}

	class Node {
		int data;
		Node below;
		Node above;

		Node() {

		}

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String args[]) {
		_3_StackOfPlates plates = new _3_StackOfPlates(3);
		plates.push(5);
		plates.push(5);
		plates.push(5);
		plates.push(15);
		plates.push(15);
		plates.push(15);
		plates.push(25);
		plates.push(25);
		plates.push(25);

		System.out.println(plates.popAt(1));
		System.out.println(plates.getLastStack().size);
	}
}