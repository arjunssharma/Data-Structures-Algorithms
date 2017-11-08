package leetcode;
import java.util.Stack;

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
	}
}

public class IterativeInorderTraversalBinaryTree {

	public static void main(String args[]) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.left.left = new Node(3);
		root.right = new Node(15);
		inorderTraversal(root);
	}

	public static void inorderTraversal(Node root) {
		if (root == null) {
			return;
		} else {
			Stack<Node> s = new Stack<Node>();
			while (true) {
				if (root != null) {
					root = s.push(root);
					root = root.left;
				} else {
					if (s.empty()) {
						break;
					} 
					root = s.pop();
					System.out.print(root.data + " ");
					root = root.right;
				}
			}
		}

	}
}
