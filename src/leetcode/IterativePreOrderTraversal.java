package leetcode;

import java.util.Stack;

public class IterativePreOrderTraversal {

	public static void main(String args[]) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.left.left = new Node(2);
		root.right = new Node(15);
		preOrderTraversal(root);
	}
	
	public static void preOrderTraversal(Node root) {
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		while (!s.empty()) {
			if (root != null) {
				root = s.pop();
				System.out.print(root.data + " ");
			}
			if (root.right != null) {
				s.push(root.right);
			}
			if (root.left != null) {
				s.push(root.left);
			}
		}

	}
}
