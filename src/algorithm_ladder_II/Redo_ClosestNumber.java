package algorithm_ladder_II;

public class Redo_ClosestNumber {
	
	public int findClosestNumber(int[] A, int target) {
		// corner case
		if (A == null || A.length == 0) {
			return -1;
		}
		
		int lo = 0, hi = A.length - 1;
		while (lo + 1 < hi) {
			int mid = lo + (hi-lo) / 2;
			if (A[mid] > target) {
				hi = mid;
			} else if (A[mid] < target) {
				lo = mid;
			} else { // found a...
				return mid;
			}
		}
		
		int distLo = Math.abs(A[lo] - target);
		int distHi = Math.abs(A[hi] - target);
		// find the closest number from lo / hi;
		
		System.out.println("lo" + A[lo] + " distLo " + distLo);
		System.out.println("hi" + A[hi] + " distHi " + distHi);
		return distLo < distHi ? lo : hi;
		
	}
	
	
	
    public static void main(String[] args) {
        int[] A = new int[] {1,2,3,7};
        int target = 4;
        Redo_ClosestNumber cn = new Redo_ClosestNumber();
        System.out.println(cn.findClosestNumber(A, target)); // expected to be 3
    }
}
