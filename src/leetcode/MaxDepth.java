package leetcode;

public class MaxDepth {
	public int maxDepth(TreeNode root) {
        if(root == null) 
            return 0;
        
        else {
            int left = 1 + maxDepth(root.left);
            int right = 1 + maxDepth(root.right);
            return Math.max(left,right);
        }
    }
}
/**
 * Definition for a binary tree node.
 * 
 */

	class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }