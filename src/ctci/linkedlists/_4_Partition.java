package ctci.linkedlists;

public class _4_Partition {

	public static void main(String args[]) {
		Node head = new Node(1);
		head.next = new Node(4);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(2);
		Node n = partition(head, 3);
		while(n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	public static Node partition(Node head, int x) {

		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;

		while (head != null) {
			Node node = head.next;
			head.next = null;
			if (head.data < x) {
				if (beforeStart == null) {
					beforeStart = head;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = head;
					beforeEnd = head;
				}
			} else {
				if (afterStart == null) {
					afterStart = head;
					afterEnd = afterStart;
				} else {
					afterEnd.next = head;
					afterEnd = head;
				}
			}
			head = node;
		}

		if (beforeStart == null)
			return afterStart;

		beforeEnd.next = afterStart;

		return beforeStart;
	}
}
