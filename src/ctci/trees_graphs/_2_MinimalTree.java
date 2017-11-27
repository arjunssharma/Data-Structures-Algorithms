package ctci.trees_graphs;

class Node {
	int data;
	Node left;
	Node right;
	public Node(int data) {
		this.data = data;
	}
}

public class _2_MinimalTree {
	
	public static Node minimalTree(int a[], int start, int end) {
		if(end < start)
			return null;
		
		int mid = (start + end) / 2;
		Node root = new Node(a[mid]);
		
		root.left = minimalTree(a, start, mid - 1);
		root.right = minimalTree(a, mid + 1, end);
		
		return root;
	}
	
	public static Node minimalTree(int a[]) {
		return minimalTree(a, 0, a.length - 1);
	}
	
	public static void main(String args[]) {
		int a[] = {1,2,3,4,5,6,7};
		Node result = minimalTree(a);
		printInorderTraversal(result);
	}
	
	public static void printInorderTraversal(Node root) {
		if(root != null) {
			printInorderTraversal(root.left);
			System.out.print(root.data + " ");
			printInorderTraversal(root.right);
		}
	}
}
