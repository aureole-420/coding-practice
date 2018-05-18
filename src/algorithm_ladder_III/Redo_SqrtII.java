package algorithm_ladder_III;

public class Redo_SqrtII {
	public double sqrt(double x) {
		
		double lo = 0, hi;
		if (x >= 1.0) hi = x;
		else hi = 1.0;
		
		double epsilon = 1e-10;
		while (lo + epsilon < hi) {
			double mid = lo + (hi-lo) / 2;
			if (Math.pow(mid, 2) < x) {
				lo = mid;
			} else if (Math.pow(mid, 2) > x) {
				hi = mid;
			} else {
				return mid;
			}
		}
		
		return lo;
	}
	
	public static void main(String[] args) {
		double x = 2;
		Redo_SqrtII s = new Redo_SqrtII();
		System.out.println(s.sqrt(x)); // should be 1.41421356
	}
}
