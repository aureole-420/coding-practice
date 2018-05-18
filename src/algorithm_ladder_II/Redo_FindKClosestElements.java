package algorithm_ladder_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Redo_FindKClosestElements {
	
	public List<Integer> findClosestElements(int[] A, int k, int x) {
		
		List<Integer> result = new ArrayList<Integer>();
		// don't consider corner case;
		if (A == null || A.length == 0 || k > A.length) {
			return result;
		} 
		// a naive solution:
		
		// find the closest number first
		int lo = 0, hi = A.length-1;
		while (lo+1 < hi) {
			int mid = lo + (hi-lo)/2;
			if (x > A[mid]) {
				lo = mid;
			} else if (x < A[mid]) {
				hi = mid;
			} else {
				lo = mid;
				hi = mid+1;
				break;
			}
		}
		
		// two pointers
		int i = lo, j = hi;
		while (result.size() < k) {
			if (i < 0) {
				result.add(A[j]);
				j++;
			} else if (j >= A.length) {
				result.add(A[i]);
				i--;
			}
			else if (Math.abs(A[i] - x) <= Math.abs(A[j] - x)) {
				result.add(A[i]);
				i --;
			} else {
				result.add(A[j]);
				j++;
			}
		}
		
		Collections.sort(result);
		return result;
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {1,2,3,4,5,6};
		int k = 5;
		int x = -1;
		Redo_FindKClosestElements f = new Redo_FindKClosestElements();
		List<Integer> res = f.findClosestElements(A, k, x);
		for (int i : res) {
			System.out.print(i + " "); // should be 1,2,3,4
		}
	}
}
