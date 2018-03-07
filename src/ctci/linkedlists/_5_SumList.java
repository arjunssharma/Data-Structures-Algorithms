package ctci.linkedlists;

public class _5_SumList {

	public static void main(String args[]) {
		Node l = new Node(7);
		l.next = new Node(1);
		l.next.next = new Node(9);
	
		Node r = new Node(5);
		r.next = new Node(9);
		r.next.next = new Node(2);
		
		Node reverse = sumListStoredInReverseOrder(l, r);
		while(reverse != null) {
			System.out.print(reverse.data + " ");
			reverse = reverse.next;
		}
	}
	
	//Input: (7 -> 1 -> 6) + (5 -> 9 -> 2) .That is,617 + 295.
	//Output: 2 -> 1 -> 9. That is, 912.
	public static Node sumListStoredInReverseOrder(Node l1, Node l2) {
		Node dummyHeader = new Node(0);
		Node current = dummyHeader;
		int carry = 0;
		while(l1 != null || l2 != null || carry != 0) {
			int a = (l1 != null)? l1.data: 0;
			int b = (l2 != null)? l2.data: 0;
			int total = a + b + carry;
			carry = total / 10;
			current.next = new Node(total % 10);
			current = current.next;
			if(l1 != null)
				l1 = l1.next;
			if(l2 != null)
				l2 = l2.next;
		}
		
//		if(carry > 0) {
//			current.next = new Node(carry);
//		}
		
		return dummyHeader.next;
	}
	
	
	//Input: (6 -> 1 -> 7) + (2 -> 9 -> 5) .That is,617 + 295.
	//Output: 9 -> 1 -> 2. That is, 912.
	public static Node sumListStoredInForwardOrder(Node l1, Node l2) {
		return null;
	}
}
