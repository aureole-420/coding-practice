package algorithm_graph_I;

import java.util.LinkedList;
import java.util.List;

public class BFS_Graph {
	
	private Graph graph;
	public BFS_Graph(Graph graph) {
		this.graph = graph;
	}
	
	public List<Integer> bfs(int s) {
		boolean[] visited = new boolean[graph.getV()];
		LinkedList<Integer> res = new LinkedList<Integer>();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (boolean v : visited) 
			v = false;
		
		queue.offer(s);
		visited[s] = true;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			res.addLast(cur);
			Iterable<Integer> neighbors = graph.getNeighbors(cur);
			for (int n : neighbors) {
				if (!visited[n])
					visited[n] = true;
					queue.offer(n);
			}
		}
		return res;	
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(2,3);
		g.addEdge(3,4);
		BFS_Graph b = new BFS_Graph(g);
		List<Integer> r = b.bfs(0);
		for (int i : r)
			System.out.print(i + " "); // should be 0 1 2 3 4
	}
}
