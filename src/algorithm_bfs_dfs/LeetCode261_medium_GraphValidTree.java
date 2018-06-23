package algorithm_bfs_dfs;

import java.util.*;

// 做前： 是树的前提： 只有一个节点， 没有环
// wiki def:  a tree is an undirected graph in which any two vertices are connected by exactly one path. 
// Every acyclic connected graph is a tree
// (1) there is only one connected component
// (2) no cycle

// 无向图的cycle detection！！！！ --- 相比有向图，还需要强调neighbour不是直接的parent
public class LeetCode261_medium_GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (n < 0) {
            return false;
        }
        /**
         * 下面的corner case是错的！！！ 
         * e.g ,没办法handle： n = 2, edges = []   -- expected to be false;
         * n = 1, edges = [] --- expected to be true;
         */
//        if (edges == null || edges.length == 0 || edges[0].length == 0) {
//        		return true;
//        }
        ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
        		graph[i] = new ArrayList<Integer>();
        }
        
        for (int[] edge : edges) {
        		graph[edge[0]].add(edge[1]);
        		graph[edge[1]].add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        boolean[] inCallStack = new boolean[n];
        
        int count = 0;
        for (int i = 0; i < n; i++) {
        		if (!visited[i]) {
        			count++;
        			if (checkCycle(i, graph, visited, inCallStack, -1)) {
        				return false;
        			}
        		}
        }
        
        if (count != 1) { // more than one connected components
        		return false;
        }
        return true;
    }
    
    private boolean checkCycle(int i, ArrayList<Integer>[] graph, boolean[] visited, boolean[] inCallStack, int parentNode) {
    		visited[i] = true;
    		inCallStack[i] = true;
    		for (int neighbour : graph[i]) {
    			if (visited[neighbour]) {
    				if (neighbour != parentNode && inCallStack[neighbour]) {
    					// cycle found;
    					return true;
    				} 
    			} else { // need to visit the neighbour
    				if (checkCycle(neighbour, graph, visited, inCallStack, i)) {
    					return true; // found cycle in subnodes
    				}
    			}
    		}
    		inCallStack[i] = false;
    		return false;
    }
}
