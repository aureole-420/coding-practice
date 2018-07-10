package algorithm_HashTable;
import java.util.*;

// 做前，感觉挺简单的啊？ 弄一个hashmap 收集 斜率，同一斜率的点在一起。

// 做中： 尼玛： 1. corner case多： points 有0个元素，1个元素时都不能计算斜率，要单独写出。。
// 2. 还能有坐标完全一样的点！！！这感觉要用一个treeset先存储一下


// 看了某一个答案，还是用slope做key，
// con： 1. double做hash key不是一个good idea
// 2. double精度问题，有test case过不了 [[0,0],[94911151,94911150],[94911152,94911151]] because of double limitations

// 看了最高票答案，用了GCD， 最大公约数; 把slope表示成分数形式，用分子+“@”+分母来做key
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
    		HashMap<String, Integer> map = new HashMap<>();
    		
    		Arrays.sort(points, (o1, o2) -> o1.x - o2.x);
    		int maxLen = -1;
    		
    		for (int i = 0; i < points.length; i++) {
    			if (i > 0 && points[i].x == points[i-1].x && points[i].y == points[i-1].y) {
    				continue; 
    			} 
    			
    			map.clear();
    			int sameP = 0;
//    			int sameX = 1; // 斜率为infinity
    			
//    			for (int j = i+1; j < points.length; j++) {
    			for (int j = i+1; j < points.length; j++) {
    				if (points[i].x == points[j].x && points[i].y == points[j].y) {
    					sameP++;
    					maxLen = sameP + 1 > maxLen ? sameP+1 : maxLen; // 万一全部都是sameP， maxLen也不会是-1
    					continue;
    				}
    				
    				int diffX = points[j].x - points[i].x;
    				int diffY = points[j].y - points[i].y;
    				int gcd = getGCD(diffX, diffY);
    				// gcd cannot be zero, so
    				int reducedX = diffX / gcd;
    				int reducedY = diffY / gcd;
    				
    				String key = Integer.toString(reducedX)+"@"+Integer.toString(reducedY);
    				map.put(key, map.getOrDefault(key, 0) + 1);
    				
    				maxLen = map.get(key) + 1 + sameP > maxLen ? map.get(key) + 1 + sameP: maxLen;
    			}	
    		}
    		
    		return maxLen;
    }
    
   //  gcd of two numbers also divides their difference
    private int getGCD(int a, int b) {
    		if (b == 0) {
    			return a;
    		} else {
    			return getGCD(b, a % b);
    		}
    }
    
    // suppose no repeated points.
    private double getSlope(Point p1, Point p2) {
    		if (p1.x == p2.x) {
    			return Double.POSITIVE_INFINITY;
    		} else {
    			return (1.0* p2.y - p1.y) / (1.0 * p2.x - p1.x);
    		}
    }
    
//    public int maxPoints(Point[] points) {
//		
//   	 // corner case:
//   	if (points == null || points.length == 0) {
//   		return 0;
//   	}
//   	
//   	if (points.length == 1) {
//   		return 1;
//   	}
//   		
////       Arrays.sort(points, new Comparator<Point>() {
////			@Override
////			public int compare(Point o1, Point o2) {
////				return o1.x - o2.x;
////			}
////       });
//   		
//   		// Key is slope, Value is number of segment with this slope
//   		HashMap<Double, Integer> map = new HashMap<>();
//   		
//   		Arrays.sort(points, (o1, o2) -> o1.x - o2.x);
//   		int maxLen = -1;
//   		
//   		for (int i = 0; i < points.length; i++) {
//   			if (i > 0 && points[i].x == points[i-1].x && points[i].y == points[i-1].y) {
//   				continue; 
//   			} 
//   			
//   			map.clear();
//   			int sameP = 0;
////   			int sameX = 1; // 斜率为infinity
//   			
////   			for (int j = i+1; j < points.length; j++) {
//   			for (int j = i+1; j < points.length; j++) {
//   				if (points[i].x == points[j].x && points[i].y == points[j].y) {
//   					sameP++;
//   					maxLen = sameP + 1 > maxLen ? sameP+1 : maxLen; // 万一全部都是sameP， maxLen也不会是-1
//   					continue;
//   				}
//   				
//   				double slope = getSlope(points[i], points[j]);
//   				map.put(slope, map.getOrDefault(slope, 0) + 1);
//   				
//   				maxLen = map.get(slope) + 1 + sameP > maxLen ? map.get(slope) + 1 + sameP: maxLen;
//   			}	
//   		}
//   		
//   		return maxLen;
//   }
}
