package algorithm_ladder_II;

import java.util.LinkedList;
import java.util.List;

/**
 *  leetcode 658
 *
 */
public class FindKClosestElements {
	public List<Integer> findClosestElements(int[] A, int k, int x) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        // corner case
        if (A == null || A.length == 0)
        		return res;
        
        // search for first x;
        int lo = 0, hi = A.length;
        while (lo + 1 < hi) {
        		int mid = lo + (hi - lo) / 2;
        		if (x > A[mid]) {
        			lo = mid;
        		} else {
        			hi = mid;
        		}
        }
        
        // expanding ...
        while (res.size() < k) {
        		if (lo >= 0 && hi < A.length) {
        			if (Math.abs(x - A[hi]) < Math.abs(x-A[lo])) {
        				res.addLast(A[hi]);
        				hi++;
        			} else {
        				res.addFirst(A[lo]);
        				lo--;
        			}
        		} else if (lo >= 0) {
        			res.addFirst(A[lo]);
        			lo--;
        		} else {
        			res.addLast(A[hi]);
        			hi++;
        		}
        }
        return res;  
    }
	
	public static void main(String[] args) {
		int[] A = new int[] {1,2,3,4,5};
		int k = 4;
		int x = 3;
		FindKClosestElements f = new FindKClosestElements();
		List<Integer> res = f.findClosestElements(A, k, x);
		for (int i : res) {
			System.out.print(i + " "); // should be 1,2,3,4
		}
	}
}
