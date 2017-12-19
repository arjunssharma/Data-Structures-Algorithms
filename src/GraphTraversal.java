import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GraphTraversal {

	static class Node {
		int data;
		boolean visited;
		List<Node> neighbours;

		Node(int data) {
			this.data = data;
			this.neighbours = new ArrayList<>();

		}

		public void addneighbours(Node neighbourNode) {
			this.neighbours.add(neighbourNode);
		}

		public List getNeighbours() {
			return neighbours;
		}

		public void setNeighbours(List neighbours) {
			this.neighbours = neighbours;
		}
	}
	
	// Recursive DFS
	public void dfs(Node node) {
		System.out.print(node.data + " ");
		List<Node> neighbours = node.getNeighbours();
		node.visited = true;
		for (int i = 0; i < neighbours.size(); i++) {
			Node n = neighbours.get(i);
			if (n != null && !n.visited) {
				dfs(n);
			}
		}
	}
	
	
	
	private Queue<Node> queue;
	static ArrayList<Node> nodes=new ArrayList<Node>();
	
	public void bfs(Node node) {
		queue.add(node);
		node.visited = true;
		while (!queue.isEmpty()) {
			Node element = queue.remove();
			System.out.print(element.data + "t");
			List<Node> neighbours = element.getNeighbours();
			for (int i = 0; i < neighbours.size(); i++) {
				Node n = neighbours.get(i);
				if (n != null && !n.visited) {
					queue.add(n);
					n.visited = true;
				}
			}

		}
	}
}
