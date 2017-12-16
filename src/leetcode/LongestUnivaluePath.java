package leetcode;

public class LongestUnivaluePath {

	int answer = 0;
	public int longestUnivaluePath(Node root) {
		if(root != null)
			helper(root);
		
		return answer;
	}
	
	public int helper(Node root) {
		int left = root.left != null ? helper(root.left) : 0;
		int right = root.right != null ? helper(root.right) : 0;
		int leftArrow = root.left != null && root.left.data == root.data ? left + 1 : 0;
		int rightArrow = root.right != null && root.right.data == root.data ? right + 1 : 0;
		answer = Math.max(answer, leftArrow + rightArrow);
		return Math.max(leftArrow, rightArrow);
	}
	
	public static void main (String args[]) {
		Node root = new Node(5);
		root.left = new Node(5);
		root.left.right = new Node(4);
		root.left.left = new Node(5);
		root.right = new Node(5);
		System.out.println(new LongestUnivaluePath().longestUnivaluePath(root));
	}
}
