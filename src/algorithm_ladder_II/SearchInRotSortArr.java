package algorithm_ladder_II;

public class SearchInRotSortArr {
	
	public int search(int[] A, int target) {
        // corner case
		if (A == null || A.length == 0) {
			return -1;
		}
		
		int lo = 0, hi = A.length-1;
		while (lo +1 < hi) {
			int mid = lo + (hi-lo)/2;
			System.out.println("[lo, hi]" + lo + " " + hi );
			if (target > A[hi]) {
				if (A[mid] == target) return mid;
				if (A[mid] < A[hi]) hi = mid;
				else if (A[mid] > target) hi = mid;
				else lo = mid;
			} else {
				if (A[mid] == target) return mid;
				if (A[mid] > A[hi]) lo = mid;
				else if (A[mid] < target) lo = mid;
				else hi = mid;
			}
		}
		
		if (A[lo] == target) return lo;
		if (A[hi] == target) return hi;
		return -1;
    }
	
	public static void main(String[] args) {
		//int[] A = new int[] {4, 5, 6, 7, 0, 1, 2};
		int[] A = new int[] {1,1,1,1,5,1,1,1};
		int target = 5;
		SearchInRotSortArr srsa = new SearchInRotSortArr();
		System.out.println(srsa.search(A, target)); // should be 5
	}
}
