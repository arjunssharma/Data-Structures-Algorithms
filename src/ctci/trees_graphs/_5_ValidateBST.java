package ctci.trees_graphs;

public class _5_ValidateBST {

	public boolean isValidBST(Node root) {
		if (root != null && root.left == null && root.right == null)
			return true;

		return isValidBSTHelperMethod(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean isValidBSTHelperMethod(Node root, Long min, Long max) {
		if (root == null)
			return true;

		if (root.data <= min || root.data >= max)
			return false;

		return isValidBSTHelperMethod(root.left, min, new Long(root.data))
				&& isValidBSTHelperMethod(root.right, new Long(root.data), max);
	}
}