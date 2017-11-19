package ctci.stacks_queues;

public class _2_StackMin {

	private class StackNode {
		int data;
		int min;
		StackNode next;
	
		public StackNode(int data, int min) {
			this(data, min, null);
		}
		
		public StackNode(int data, int min, StackNode next) {
			this.data = data;
			this.min = min;
			this.next = next;
		}
	}
	
	StackNode head;
	
	public void push(int data) {
		if(head == null) {
			head = new StackNode(data, data);
		} else {
			head = new StackNode(data, Math.min(data, head.min), head);
		}
	}
	
	public int pop() {
		StackNode removed = head;
		head = head.next;
		return removed.data;
	}
	
	public int peek() {
		return head.data;
	}
	
	public int getMin() {
		return head.min;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	//Test
	public static void main(String args[]) {
		_2_StackMin object = new _2_StackMin();
		object.push(12);
		object.push(20);
		object.push(2);
		object.push(30);
		object.push(50);
		
		System.out.println(object.getMin());
		System.out.println(object.peek());
		
	}
}
