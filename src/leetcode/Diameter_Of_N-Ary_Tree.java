package leetcode;

public class Diameter_Of_N_Ary_Tree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    int result = 0;
    public int diameter(Node root) {
        traverse(root);
        return result;
    }

    public int traverse(Node root) {
        if(root == null)
            return 0;

        int max1 = 0;
        int max2 = 0;
        //calculate top 2 max height subtrees

        for(Node node : root.children) {
            int height = traverse(node);
            if(height > max1) {
                max2 = max1;
                max1 = height;
            }
            else if(height > max2) {
                max2 = height;
            }
        }

        result = Math.max(result, max1 + max2);

        //Math.max(max1, max2) will always be max1
        return Math.max(max1, max2) + 1;
    }
}