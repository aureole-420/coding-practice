package algorithm_dp;

public class LeetCode213_medium_HouseRobber_II {
	
	// f[k] = max(f[k-1], f[k-2] + A[k])
	// maintain two pointer, fk_1,fk
	private int rob(int[] nums, int lo, int hi) {
		
		int prevMax = 0, currMax = 0; 
		for (int i = lo; i <= hi; i++) {
			int temp = currMax;
			currMax = Math.max(currMax, prevMax+nums[i]);
			prevMax = temp;
		}
		
		return currMax;
	}
	
    public int rob(int[] nums) {
    	int N = nums.length;
    	if (N == 1) return nums[0]; // 有N个房子
    	
    	// otherwisw 有N-1个房子 --- 错，误解了，还是N个房子
        return Math.max(rob(nums, 0, N-2), rob(nums, 1, N-1));
    }
    
    public static void main(String[] args) {
    	int[] nums = new int[] {2,3,2};
    	LeetCode213_medium_HouseRobber_II hr = new LeetCode213_medium_HouseRobber_II();
    	System.out.println(hr.rob(nums));
    }
}
