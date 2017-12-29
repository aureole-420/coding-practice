package algorithm_ladder_III;

public class Sqrt {
	public int mySqrt(int x) {
        // corner case;
		if (x == 0) return 0;
		
		
		int lo = 1, hi = x;
		while (lo + 1 < hi) {
			int mid = lo + (hi - lo) / 2;
			if (mid * mid < x) lo = mid;
			else if (mid * mid > x) hi = mid;
			else return mid;
		}
		System.out.println(lo + " " + hi);
		
		if (hi * hi <= x) return hi;
		else return lo;
    }
	
	public static void main(String[] args) {
		int x = 8;
		Sqrt s = new Sqrt();
		System.out.println(s.mySqrt(x)); // should be 2
	}
}
