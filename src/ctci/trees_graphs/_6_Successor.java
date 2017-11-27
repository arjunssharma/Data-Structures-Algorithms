package ctci.trees_graphs;

public class _6_Successor {

	private class Node {
		int data;
		Node left;
		Node right;
		Node parent;
	}
	
	public Node inorderSuccessor(Node n) {
		if(n == null)
			return null;
		
		if(n.right != null) {
			return leftMostChild(n.right);
		}
		else {
			Node current = n;
			Node parent = current.parent;
			while(parent != null && parent.left != current) {
				current = parent;
				parent = parent.parent;
			}
			return parent;
		}
	}
	
	public Node leftMostChild(Node node) {
		if(node == null)
			return null;
		
		while(node.left != null) {
			node = node.left;
		}
		
		return node;
	}
}