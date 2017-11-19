package ctci.linkedlists;

public class _8_LoopDetection {

	public static void main(String args[]) {
		Node head = new Node(1);
		head.next = new Node(4);
		head.next.next = new Node(3); //cycle
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = head.next.next;
		System.out.println(findBeginningOfLoop(head).data);
	}
	
	public static Node findBeginningOfLoop(Node head) {
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow)
				break;
		}
		
		if(fast == null || fast.next == null)
			return null;
		
		slow = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast;
	}
	
}
