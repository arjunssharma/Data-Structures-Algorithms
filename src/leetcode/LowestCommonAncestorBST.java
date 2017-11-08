package leetcode;


public class LowestCommonAncestorBST {

	public static void main(String args[]) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.left.left = new Node(2);
		root.right = new Node(15);
		System.out.println(lca(root, root.left, root.left.left).data);
	}
	
	public static Node lca(Node root, Node n1, Node n2) {
	    	 if(root.data > Math.max(n1.data, n2.data)) {
	    		 return lca(root.left, n1, n2);
	    	 }
	    	 else if(root.data > Math.max(n1.data, n2.data)){
	    		 return lca(root.right, n1, n2);
	    	 }
	    	 else {
	    		 return root;
	    	 }
	}
}