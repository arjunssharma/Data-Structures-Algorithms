package ctci.trees_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _3_ListOfDepths {
	
	public List<LinkedList<Node>> listOfDepths(Node root) {
		List<LinkedList<Node>> list = new ArrayList<LinkedList<Node>>();
		
		LinkedList<Node> current = new LinkedList<Node>();
		if (root != null) {
			current.add(root);
		}
		
		while (!current.isEmpty()) {
			list.add(current);
			LinkedList<Node> parents = current; //next level
			current = new LinkedList<Node>();
			for(Node parent : parents) {
				if(parent.left != null)
					current.add(parent.left);

				if(parent.right != null)
					current.add(parent.right);
			}
		}
		return list;
	}
}
