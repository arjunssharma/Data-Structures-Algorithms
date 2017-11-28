package ctci.trees_graphs;

import java.util.LinkedList;

import ctci.trees_graphs.GraphClassForProblem1.Node;
import ctci.trees_graphs.GraphClassForProblem1.State;;

public class _1_RouteBetweenNodes {

	
	public boolean search(GraphClassForProblem1 g, Node start, Node end) {
		if(start == end)
			return true;
		
		LinkedList<Node> q = new LinkedList<Node>();
		
		for(Node n : g.getNodes()) {
			n.state = State.unvisited;
		}
		
		start.state = State.visiting;
		q.add(start);
		Node u;
		while(!q.isEmpty()) {
			u = q.removeFirst();
			if(u != null) {
				for(Node v : u.getAdjacent()) {
					if(v.state == State.unvisited) {
						if(v == end)
							return true;
						else {
							v.state = State.visiting;
							q.add(v);
						}
					}
				}
				u.state = State.visited;
			}
		}
		return false;
	}
}
