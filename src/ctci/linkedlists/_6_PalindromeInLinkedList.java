package ctci.linkedlists;

import java.util.ArrayList;
import java.util.List;

public class _6_PalindromeInLinkedList {

	public boolean isPalindrome(Node head) {
        if(head == null)
            return true;

    List<Integer> array = new ArrayList<>();
	Node current = head;
	while (current != null) {
		array.add(current.data);
		current = current.next;
	}
		
// then we compare the head and tail one by one, until i  is not less than j anymore
	int i = 0, j = array.size() - 1;
	while (i < j) {
	if (!array.get(i).equals(array.get(j))) 
            return false;
		i++;
		j--;
	}
		return true;   
    }
}
