package leetcode;

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        int result = 0;
        if(root == null)
            return result;
        
        root.val = 0;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            result = Math.max(result, queue.peekLast().val - queue.peekFirst().val + 1);
            for(int i = 0; i < size; i++) {
                root = queue.poll();
                if(root.left != null) {
                    root.left.val = 2 * root.val + 1;
                    queue.offer(root.left);
                }
                if(root.right != null) {
                    root.right.val = 2 * root.val + 2;
                    queue.offer(root.right);
                }
            }
        }
        
        return result;
    }
}