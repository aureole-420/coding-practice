package algorithm_bfs_dfs;
import java.util.*;


// dye nodes into BLACK and RED color
// dfs everynode, check if adjacent nodes are of different color.
public class LeetCode785_medium_IsGraphBipartite {
    public boolean isBipartite(int[][] edges) {
    		HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
    		
    		for (int curNode = 0 ; curNode < edges.length; curNode++) {
    			graph.putIfAbsent(curNode, new HashSet<Integer>());
    			for (int neighbour : edges[curNode]) {
    				graph.putIfAbsent(neighbour, new HashSet<Integer>());
    				graph.get(curNode).add(neighbour);
    				graph.get(neighbour).add(curNode);
    			}
    		}
    		
    		HashMap<Integer, Boolean> visited = new HashMap<>();
    		HashMap<Integer, Boolean> isRed = new HashMap<>();
    		for (int node : graph.keySet()) {
    			visited.put(node, false);
    			isRed.put(node, false);
    		}
    		
    		for (int node : graph.keySet()) {
    			if (visited.get(node)) {
    				continue;
    			}
    			// otherwise dye this node ( and connected ndoes)
    			if (!dyeColor(graph, visited, isRed, node, true)) {
    				return false;
    			}
    		}
    		return true;
    }
    
    // return true if successfully bipartitie, ortherwise return false;
    private boolean dyeColor(HashMap<Integer, HashSet<Integer>> graph, 
    		HashMap<Integer, Boolean> visited, HashMap<Integer, Boolean> isRed,
    		int curNode, boolean dyeRed) {
    	
    		visited.put(curNode, true);
    		isRed.put(curNode, dyeRed);
    		
    		for (int neighbour : graph.get(curNode)) {
    			if (visited.get(neighbour)) {
    				if (isRed.get(curNode) == isRed.get(neighbour)) {
    					return false;
    				}
    			} else {
    				if (!dyeColor(graph, visited, isRed, neighbour, !dyeRed)) {
    					return false;
    				}
    			}
    		}
    		
    		return true; // sucessfully dye this componenet.
    }
}
