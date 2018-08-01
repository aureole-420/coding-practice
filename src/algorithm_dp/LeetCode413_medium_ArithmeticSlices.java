package algorithm_dp;

// sequence dp
// f[i]: number of AS ended with the ith elements;
public class LeetCode413_medium_ArithmeticSlices {
	
    public int numberOfArithmeticSlices(int[] A) {
        
    	if (A == null || A.length < 3) {
    		return 0;
    	}
    	
    	int N = A.length;
    	int[] f = new int[N];
    	int ans = 0;
    	if (A[0] + A[2] == 2 * A[1]) {
    		f[2] = 1;
    	}
    	ans += f[2];
    	
    	// transition
    	for (int i = 3; i < N; i++) {
    		if (A[i] + A[i-2] == 2*A[i-1]) {
    			f[i] = f[i-1] + 1;
    		}
    		ans += f[i];
    	}
    	
    	// ans
    	return ans;
	
    }
}
