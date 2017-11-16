package leetcode;

import java.util.*;

public class BinaryTreeReverseLevelOrderTraversal {

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		System.out.println(traversal(root));
	}
	
	public static List<List<Integer>> traversal(TreeNode root) {
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		if(root == null)
			return result;
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(queue.size() > 0) {
			List<Integer> list = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.remove();
				list.add(node.val);
				if(node.left != null)
					queue.add(node.left);
				if(node.right != null)
					queue.add(node.right);
			}
			result.addFirst(list);
		}
		
		return result;
	}
}
