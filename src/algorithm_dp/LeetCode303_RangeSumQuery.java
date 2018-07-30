package algorithm_dp;

public class LeetCode303_RangeSumQuery {
	// 用表把结果存起来
	// 哇，这题用presum来做超快！！！
	
	private int[] preSum;
	
    public void NumArray(int[] nums) {
        preSum = new int[nums.length+1];
        // presum[0]=0;
        for (int i = 0; i < nums.length; i++) {
        	preSum[i+1] = preSum[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return preSum[j+1] - preSum[i];
    }
}
