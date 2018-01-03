package algorithm_graph_I;

import java.util.*;

public class Graph {
	private int V; // number of vertices
	private LinkedList<Integer>[] adj;
	public Graph(int V) {
		this.V = V;
		this.adj = (LinkedList<Integer>[]) new LinkedList[V];
		for (int v = 0; v < V; v++)
			adj[v] = new LinkedList<Integer>();
	}
	
	public void addEdge(int v, int w) { // edge v->w
		adj[v].add(w);
	}
	
	public int getV() {
		return V;
	}
	
	public LinkedList<Integer>[] getAdj() {
		return adj;
	}
	
	public LinkedList<Integer> getNeighbors(int v) {
		return adj[v];
	}
	
}
