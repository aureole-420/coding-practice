package algorithm_bfs_dfs;
import java.util.*;

// 有向图，dfs起点k，同时搜集最大的path sum
// https://leetcode.com/problems/network-delay-time/solution/
// 做后感想： dijkstra's algorithm 这个实现真是很tricky，老爷爷的书上用的是
public class LeetCode743_medium_NetworkDelayTime {
	
	// N nodes, starting from node K.
    public int networkDelayTime(int[][] times, int N, int K) {
    		// e.g. node 1 : (2, w1)->(3,w2) ... 
    		HashMap<Integer, List<int[]>> graph = new HashMap<>();
    		for (int[] edge : times) {
    			graph.putIfAbsent(edge[0], new ArrayList<int[]>());
    			graph.get(edge[0]).add(new int[] {edge[1], edge[2]});
    		}
    		
    		// each elem: [distance, ]
    		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}    			
    		});
    		pq.offer(new int[] {0, K});
    		
    		HashMap<Integer, Integer> dist = new HashMap<>();
    		
    		
    		while(!pq.isEmpty()) {
    			int[] info = pq.poll();
    			int d = info[0], node = info[1];
    			if (dist.containsKey(node)) continue;
    			
    			dist.put(node, d);
    			if (graph.containsKey(node)) {
    				for (int[] edge : graph.get(node)) {
    					int neighbour = edge[0], weight = edge[1];
    					if (!dist.containsKey(neighbour)) {
    						pq.offer(new int[] {d + weight, neighbour});
    					}
    				}
    			}
    		}
    		
    		if (dist.size() != N) {
    			return -1;
    		}
    		
    		int ans = 0;
    		for (int cand: dist.values()) {
    			ans = Math.max(ans, cand);
    		}
    		return ans;
    }
    

    
    public static void main(String[] args) {
    		HashMap<int[], Integer> map = new HashMap<>();
    		map.put(new int[] {1,2}, 3);
    		System.out.println(map.get(new int[] {1,2}));
    		
//    		PriorityQueue<int[]> pq = new PriorityQueue<>((item1, item2)->item1[0]-item2[0]);
//    		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]> () {
//    			
//				@Override
//				public int compare(int[] o1, int[] o2) {
//					return o1[0] - o2[0];
//				}
//    		});
//
//    		pq.offer(new int[] {1, 11});
//    		pq.offer(new int[] {1, 12});
//    		pq.offer(new int[] {2, 21});
//    		System.out.println(pq.size());
//    		
//    		while (!pq.isEmpty()) {
//    			System.out.println(pq.poll()[1]);
//    		}
    		
    		PriorityQueue<int[]> heap = new PriorityQueue<>((info1, info2)-> info1[0] - info2[0]);
    		heap.offer(new int[] {1,11});
    		heap.offer(new int[] {2,21});
    		heap.offer(new int[] {1,13});
    		
//    		heap.remove(new int[] {1,11});
    		while (!heap.isEmpty()) {
    			System.out.println(heap.poll()[1]);
    			
    		}
    		
    		
    }
}
