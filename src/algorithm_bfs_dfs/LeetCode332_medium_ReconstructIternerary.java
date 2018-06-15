package algorithm_bfs_dfs;

import java.util.*;

// https://leetcode.com/problems/reconstruct-itinerary/description/
// https://leetcode.com/problems/reconstruct-itinerary/discuss/78766/Share-my-solution
// Eulerian path
// 这题已经明确说了
// 1. always start from "JFK"
// 2. 路径一定存在！
//
// 所以可以从jfk出发，每一步都取最好的路径
public class LeetCode332_medium_ReconstructIternerary {
    public List<String> findItinerary(String[][] tickets) {
    	
        HashMap<String, PriorityQueue<String>> flights = new HashMap<>();
        LinkedList<String> result = new LinkedList<>();
        
        for (String[] ticket : tickets) {
        		flights.putIfAbsent(ticket[0], new PriorityQueue<String>());
        		flights.get(ticket[0]).offer(ticket[1]);
        }
        
        dfs("JFK", flights, result);
        
        return result;
    }
    
    private void dfs(String departure, HashMap<String, PriorityQueue<String>> flights, LinkedList<String> result) {
    		PriorityQueue<String> arrivals = flights.get(departure);
    		// 这里不能用for！
    		while (arrivals != null && !arrivals.isEmpty()) {
    			dfs(arrivals.poll(), flights, result);
    		}
    		
    		result.addFirst(departure);
    }
}
