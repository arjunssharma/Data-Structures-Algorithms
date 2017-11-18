package ctci.linkedlists;

public class _2_ReturnKthToLast {

	public static void main(String args[]) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		head.next.next.next = new Node(3);
		Node h = returnKthToLast(head, 3);
		while(h != null) {
			System.out.print(h.data + " ");
			h = h.next;
		}
			
	}
	
	public static Node returnKthToLast(Node head, int k) {
		Node p = head;
		Node q = head;
		
		for(int i = 0; i < k; i++) {
			if(p == null)
				return null;
			p = p.next;
		}
		
		
		while (p != null) {
			p = p.next;
			q = q.next;
		}
		return q;
	}
}
