package ctci.linkedlists;

import java.util.*;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}
}

public class _1_RemoveDuplicates {

	public static void main(String args[]) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		head.next.next.next = new Node(3);
		//LL 1,2,1,3
		removeDuplicate(head);
		while(head != null){
			System.out.print(head.data + " ");
			head = head.next;
		}
			
	}

	public static void removeDuplicate(Node head) {
		Set<Integer> set = new HashSet<Integer>();
		Node current = head;
		Node previous = null;
		while(current != null) {
			if(set.contains(current.data)) {
				previous.next = current.next;
			} else {
				set.add(current.data);
				previous = current;
			}
			current = current.next;
		}
	}
}
