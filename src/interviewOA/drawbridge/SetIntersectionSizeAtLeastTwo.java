package interviewOA.drawbridge;

import java.util.*;

/*
 * leetcode 757
 */
public class SetIntersectionSizeAtLeastTwo {
    public int intersectionSizeTwo(int[][] intervals) {
    	
        LinkedList<Integer> miSet = new LinkedList<Integer>(); // Minimum Intersection Set 
        
        // first reorder the intervals.
        Arrays.sort(intervals, new Comparator<int[]> () {
			@Override
			public int compare(int[] a, int[] b) {
				return a[1] != b[1] ? Integer.compare(a[1], b[1]): Integer.compare(b[0], a[0]);
			}
        });
        
        // greedily find the miSet
        int size = 0, max = -1, second = -1;
        for (int i = 0; i < intervals.length; i++) {
        		int s = intervals[i][0];
        		int e = intervals[i][1];
        		boolean isLargestIn = (s <= max);
        		boolean isSecondIn = (s <= second);
        		
        		if (isLargestIn && isSecondIn)  // both in
        			continue;
        		
        		if (isLargestIn) { // only the largest in
        			size++;
        			second = max;
        			max = e;
        			//miSet.addLast(e);
        		}
        		
        		// none in
        		else {
        			size += 2;
        			max = e;
        			second = e-1;
        		}
        }
        
        return size;
    }
    
    public static void main(String[] args) {
//    		int[][] intervals = new int[][] {{1, 2}, {2, 3}, {2, 4},{4, 5}};
    		int[][] intervals = new int[][] {{0,2}, {0, 3}, {0, 2}};
    		SetIntersectionSizeAtLeastTwo s = new SetIntersectionSizeAtLeastTwo();
    		int misSize = s.intersectionSizeTwo(intervals);
    		System.out.println(misSize); // should be 5
    }
}
