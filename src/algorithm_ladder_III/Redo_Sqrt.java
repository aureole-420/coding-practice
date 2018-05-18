package algorithm_ladder_III;

public class Redo_Sqrt {
	
	public int mySqrt(int x) {
		// corner case: x < 0
		//
		
		int lo = 0, hi = x;
		while (lo + 1 < hi) {
			int mid = lo + (hi-lo)/2;
			if (((int) Math.pow(mid, 2)) < x) {
				lo = mid;
			} else if (((int) Math.pow(mid, 2)) > x) {
				hi = mid;
			} else {
				return mid;
			}
		}
		
		if (((int) Math.pow(hi, 2)) <= x) {
			return hi;
		} else {
			return lo;
		}
		
	}
	
	public static void main(String[] args) {
		int x = 1;
		Redo_Sqrt s = new Redo_Sqrt();
		System.out.println(s.mySqrt(x)); // should be 2
	}
}
