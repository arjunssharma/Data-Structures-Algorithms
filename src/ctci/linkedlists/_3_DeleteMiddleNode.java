package ctci.linkedlists;

public class _3_DeleteMiddleNode {

	public static void main(String args[]) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(4);
		deleteMiddleNodeWithNoAccessToHead(head.next);
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
	
	public static void deleteMiddleNode(Node head) {
		int count = 0;
		Node h = head;
		while(h != null) {
			count++;
			h = h.next;
		}
		
		Node p = head;
		int deletePointer = count % 2 == 0 ? count / 2: (count + 1)/2;
		for(int i = 1 ; i < deletePointer - 1; i++) {
			if(p == null)
				return;
			p = p.next;
		}
		
		p.next = p.next.next;
	}
	
	public static boolean deleteMiddleNodeWithNoAccessToHead(Node node) {
		if(node == null || node.next == null)
			return false;
		
		node.data = node.next.data;
		node.next = node.next.next;
		return true;
	}
}