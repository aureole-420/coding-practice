package algorithm_HashTable;
import java.util.*;

// 做前，感觉挺简单的啊？ 弄一个hashmap 收集 斜率，同一斜率的点在一起。

// 做中： 尼玛： 1. corner case多： points 有0个元素，1个元素时都不能计算斜率，要单独写出。。
// 2. 还能有坐标完全一样的点！！！

public class LeetCode149_hard_MaxPointsOnALine {
    public int maxPoints(Point[] points) {
    		
    	 // corner case:
    	if (points == null || points.length == 0) {
    		return 0;
    	}
    	
    	if (points.length == 1) {
    		return 1;
    	}
    		
//        Arrays.sort(points, new Comparator<Point>() {
//			@Override
//			public int compare(Point o1, Point o2) {
//				return o1.x - o2.x;
//			}
//        });
    		
    		// Key is slope, Value is number of segment with this slope
    		HashMap<Double, Integer> map = new HashMap<>();
    		
    		Arrays.sort(points, (o1, o2) -> o1.x - o2.x);
    		int maxLen = -1;
    		
    		for (int i = 0; i < points.length; i++) {
    			map.clear();
    			
//    			for (int j = i+1; j < points.length; j++) {
    			for (int j = i+1; j < points.length; j++) {
    				double slope = getSlope(points[i], points[j]);
    				map.put(slope, map.getOrDefault(slope, 0) + 1);
    				
    				maxLen = map.get(slope) + 1 > maxLen ? map.get(slope) + 1 : maxLen;
    			}	
    		}
    		
    		return maxLen;
    }
    
    // suppose no repeated points.
    private double getSlope(Point p1, Point p2) {
    		if (p1.x == p2.x) {
    			return Double.POSITIVE_INFINITY;
    		} else {
    			return (1.0* p2.y - p1.y) / (1.0 * p2.x - p1.x);
    		}
    }
}
