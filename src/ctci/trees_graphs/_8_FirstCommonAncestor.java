package ctci.trees_graphs;

public class _8_FirstCommonAncestor {

	public static Node firstCommonAncestor(Node root, Node n, Node p) {
		if(root == null)
			return null;
		
		if(root == n || root == p)
			return root;
		
		Node left = firstCommonAncestor(root.left, n, p);
		Node right = firstCommonAncestor(root.right, n, p);
		
		if(left != null && right != null)
			return root;
		
		if(left == null && right == null)
			return null;
		
		return left != null ? left : right;
	}
	
	public static void main(String args[]) {
		Node root = new Node(3);
		root.left = new Node(4);
		root.left.left = new Node(8);
		root.left.right = new Node(9);
		root.right = new Node(7);
		root.right.left = new Node(6);
		root.right.right = new Node(5);
		
		Node n = root.right.left;
		Node p = root.left.right;
		System.out.println(firstCommonAncestor(root, n, p).data);
	}
}
