package leetcode;

public class LowestCommonAncestorBinaryTree {

	public static void main(String args[]){
		Node root = new Node(10);
		root.left = new Node(5);
		root.left.left = new Node(2);
		root.right = new Node(15);
		System.out.println(lca(root, root.left, root.left.left).data);
	}
	
	public static Node lca(Node root, Node n1, Node n2) {
		if(root == null) {
			return null;
		}
		if(root == n1 || root == n2) {
			return root;
		}
		Node left = lca(root.left, n1, n2);
		Node right = lca(root.right, n1, n2);
		if(left == null && right == null) {
			return null;
		}
		if(left != null && right != null){
			return root;
		}
		return left != null ? left: right;
	}
}
