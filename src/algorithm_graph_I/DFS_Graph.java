package algorithm_graph_I;

import java.util.LinkedList;
import java.util.List;

public class DFS_Graph {
	private Graph g;
	private boolean[] visited;
	public DFS_Graph(Graph g) {
		this.g = g;
		visited = new boolean[g.getV()];
		for (int v = 0; v < g.getV(); v++)
			visited[v] = false;
	}
	
	public LinkedList<Integer> dfs(int s) {
		LinkedList<Integer> res = new LinkedList<>();
		dfsHelper(s, res);
		return res;
	}
	
	private void dfsHelper(int v, LinkedList<Integer> res) {
		res.addLast(v);
		for (int n : g.getNeighbors(v)) {
			if (!visited[n])
				dfsHelper(n, res);
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(0,1);
		g.addEdge(1, 5);
		g.addEdge(0,2);
		g.addEdge(2,3);
		g.addEdge(3,4);
		DFS_Graph d = new DFS_Graph(g);
		List<Integer> r = d.dfs(0);
		for (int i : r)
			System.out.print(i + " "); // should be 0 1 5 2 3 4
	}
}	
