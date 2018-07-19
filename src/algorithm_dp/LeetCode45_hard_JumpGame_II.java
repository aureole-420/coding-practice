package algorithm_dp;

// f[i], number of jumps needed to reach position i
// init: f[0] = 0
// transfer: f[i]

// 可以用贪心优化。事实上每个f第一次被赋值就一定是最小值，不需要比较！所以每次从后往前搜索，只赋给需要赋值的那些位置。
public class LeetCode45_hard_JumpGame_II {
	
    public int jump(int[] nums) {
        int N = nums.length;
        
        // states:
        int[] f = new int[N];
        
        // init
        f[0] = 0;
        for (int i = 1; i < N; i++) {
        	f[i] = Integer.MAX_VALUE;
        }
        
        // transfer
//        for (int i = 0; i < N; i++) {
//        	for (int j = i+1; j < N && j <= i + nums[i]; j++) {
//        		if (f[i] + 1 < f[j]) {
//        			f[j] = f[i] + 1;
//        		}
//        	}
//        }
        
        for (int i = 0; i < N; i++) {
        	for (int j = Math.min(N-1, i+nums[i]); j >= i+1; j--) {
        		if (f[j] != Integer.MAX_VALUE) {
        			break;
        		}
        		if (f[i] + 1 < f[j]) {
        			f[j] = f[i] + 1;
        		}
        	}
        }
        return f[N-1];
    }
}
