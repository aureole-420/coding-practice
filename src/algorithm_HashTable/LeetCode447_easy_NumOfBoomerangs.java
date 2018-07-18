package algorithm_HashTable;
import java.util.*;

// 做前：每个点搜索，把所有的等距离的点放在一起
// ？ 如果多点重复应该怎么做？

// 做中： 看了答案，仔细看题目，发现想多了，明白的说了pairwaise distinct
public class LeetCode447_easy_NumOfBoomerangs {
	
    public int numberOfBoomerangs(int[][] points) {
    	
    	HashMap<Integer, Integer> map = new HashMap<>();
    	
    	int result = 0;
    	for (int i = 0; i < points.length; i++) {
    		
    		for (int j = 0; j < points.length; j++) {
    			if (i == j) continue;
    			
    			int distance = getDistance(points[i], points[j]);
    			map.put(distance, map.getOrDefault(distance, 0) + 1);
    		}
    		
    		for (int dist : map.keySet()) {
    			int count = map.get(dist);
    			result += count * (count-1);
    		}
    		map.clear(); // map要清空！！！
    	}
    	
    	return result;
    }
    
    private int getDistance(int[] p1, int[] p2) {
    	int dx = p1[0] - p2[0];
    	int dy = p1[1] - p2[1];
    	return dx * dx + dy * dy;
    }
}
