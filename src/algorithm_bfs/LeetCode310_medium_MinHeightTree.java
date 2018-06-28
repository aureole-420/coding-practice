package algorithm_bfs;
import java.util.*;
// 做前：只想到O(n^2)的做法：
// bfs 每个节点，然后最后找到Height最小的tree

// 做中： 看了答案，逆天！！！
// desired tree: root在最长路径的中间 
// Implementation： similar to BFS topological sort, 
// 1. remove leaves, 
// 2. update the degrees of inner vertexes,
// 3. remove new leaves
// 4. doing so level by level until there are 2 or 1 nodes left.


// 原理：discussion第一名的某个评论：
// Any node that has already been a leaf cannot be the root of a MHT, because its adjacent non-leaf node will always be a better candidate.
public class LeetCode310_medium_MinHeightTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    		// corner case:
    		if (n == 1) {
    			List<Integer> res = new ArrayList<>();
    			res.add(0);
    			return res;
    		}
    	
        // build graph:
    		List<HashSet<Integer>> graph = new ArrayList<>();
    		for (int i = 0; i < n; i++) {
    			graph.add(new HashSet<Integer>());
    		}
    		
    		for (int[] edge : edges) {
    			graph.get(edge[0]).add(edge[1]);
    			graph.get(edge[1]).add(edge[0]);
    		}
    		
    		List<Integer> leaves = new ArrayList<>();
    		for (int i = 0; i < n; i++) {
    			if (graph.get(i).size() == 1) {
    				leaves.add(i);
    			}
    		}
    		
    		int numOfNodeLeft = n;
    		while (numOfNodeLeft > 2) {
    			numOfNodeLeft -= leaves.size();
    			
    			List<Integer> newLeaves = new ArrayList<>();
    			// remove all leaves
    			for (int leaf: leaves) {
    				int parent = graph.get(leaf).iterator().next();
    				graph.get(parent).remove(leaf);
    				
    				// next possible leaf can only be the parent of current leaf -- after removing current leaf.
    				if (graph.get(parent).size() == 1) {
    					newLeaves.add(parent);
    				}
    			}
    			
    			leaves = newLeaves;
    		}
    		
    		return leaves;
    }
}
