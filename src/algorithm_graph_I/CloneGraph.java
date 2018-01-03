package algorithm_graph_I;

import java.util.*;

/*
 * 分成两步
 * (1) bfs/dfs复制节点。
 * (2) bfs/dfs复制edges
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    		if (node == null) 
    			return null;
    	
        // phase I 
    		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    		Set<UndirectedGraphNode> marked = new HashSet<>();
    		Queue<UndirectedGraphNode> queue = new LinkedList<>();
    		queue.offer(node);
    		marked.add(node);
    		while (!queue.isEmpty()) {
    			UndirectedGraphNode curNode = queue.poll();
    			map.put(curNode, new UndirectedGraphNode(curNode.label)); // copy node;
    			
    			for (UndirectedGraphNode n : curNode.neighbors) {
    				if (!marked.contains(n)) {
    					marked.add(n);
    					queue.offer(n);
    				}
    			}
    		}
    		
    		
    		// phase II copy edges;
    		marked.clear();
    		queue.offer(node);
    		marked.add(node);
    		while (!queue.isEmpty()) {
    			UndirectedGraphNode curNode = queue.poll();
    			UndirectedGraphNode curNodeCopy = map.get(curNode);
    			
    			for (UndirectedGraphNode n : curNode.neighbors) {
    				curNodeCopy.neighbors.add(map.get(n));
    				if (!marked.contains(n)) {
    					marked.add(n);
    					queue.offer(n);
    				}
    			}
    		}
    		
    		return map.get(node);
    }
}
