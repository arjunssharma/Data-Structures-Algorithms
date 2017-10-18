package Blackrock;

class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

public class LowestCommonAncestor {
	Node root;

	Node findLowestCommonAncestor(Node node, int n1, int n2) {
		if (node == null) {
			return null;
		} else if (node.data < n1 && node.data < n2) {
			return findLowestCommonAncestor(node.right, n1, n2);
		} else if (node.data > n1 && node.data > n2) {
			return findLowestCommonAncestor(node.left, n1, n2);
		}
			
		return node;
	}

	public static void main(String args[]) {
		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root = new Node(30);
		tree.root.left = new Node(8);
		tree.root.right = new Node(52);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(20);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(29);

		int n1 = 3, n2 = 29;
		Node t = tree.findLowestCommonAncestor(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
		
	}
}
