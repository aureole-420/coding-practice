package algorithm_graph_I;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


// two pass, first pass: bfs V+E
// second pass: V+E
public class LeetCode133_CloneGraphs {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    		
    		if (node == null) {
    			return null;
    		}
    		
    		// phase I, find out / copy all nodes
        HashMap<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<>();  
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
       
        queue.offer(node);
        nodeMap.put(node, new UndirectedGraphNode(node.label));
        
        while (!queue.isEmpty()) {
        		UndirectedGraphNode cur = queue.poll();
        		for (UndirectedGraphNode nd : cur.neighbors) {
        			if (!nodeMap.containsKey(nd)) { // unvisited node
        				nodeMap.put(nd, new UndirectedGraphNode(nd.label));
        				queue.offer(nd);
        			}
        		}
        } 
        
        // phase II, clone all links
        for (UndirectedGraphNode nd : nodeMap.keySet()) {
        		UndirectedGraphNode cloneNd = nodeMap.get(nd);
        		for (UndirectedGraphNode neighbour : nd.neighbors) {
        			cloneNd.neighbors.add(nodeMap.get(neighbour));
        		}
        }
        
        return nodeMap.get(node);
        
    }
}
