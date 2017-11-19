package ctci.linkedlists;

import java.util.HashSet;
import java.util.Set;

public class _7_LinkedListsIntersection {

	public Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null)
            return null;
        
        Set<Node> set = new HashSet<Node>();
        
        Node a = headA;
        Node b = headB;
        while(a != null) {
            set.add(a);
            a = a.next;    
        }
        
        while(b != null) {
            if(set.contains(b))
                return b;
            b = b.next;
        }
        
        return null;
    }
}
