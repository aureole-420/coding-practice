package algorithm_ladder_III;

public class SqrtII {	
	public double sqrt(double x) {
		double lo = 0.0, hi;
        if (x > 1) hi = x;
        else hi = 1;
        
        while (lo + 1e-12 < hi) {
        		double mid = lo + (hi-lo) / 2;
        		if (x < mid * mid) hi = mid;
        		else if (x > mid * mid) lo = mid;
        		else return mid;
        }
        return lo;
    }

	public static void main(String[] args) {
		double x = 2;
		SqrtII s = new SqrtII();
		System.out.println(s.sqrt(x)); // should be 1.41421356
	}
}
