package ctci.trees_graphs;

public class _4_CheckBalanced {

	public boolean isBalanced(Node root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}

	public int checkHeight(Node root) {
		if(root == null)
			return -1;
		
		int leftHeight = checkHeight(root.left);
		if(leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		int rightHeight = checkHeight(root.right);
		if(rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		int heightDifference = Math.abs(leftHeight - rightHeight);
		if(heightDifference > 1)
			return Integer.MIN_VALUE;
		else 
			return Math.max(rightHeight, leftHeight) + 1;
	}
}