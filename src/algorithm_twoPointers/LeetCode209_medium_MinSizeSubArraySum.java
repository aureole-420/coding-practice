package algorithm_twoPointers;

// 做前：第一想法是dp， 仔细想了·一下其实可以不用dp存储，直接 start,end指针+ sum存储，因为end最多到len(arr)，所以guarantee O(n)

// 做中： follow up， 要写一个O(nlogn)的解法 
// 解释： 虽然nums不是有序的，但他们的cumulative sum（positive ）是有序的，所以可以用binary search！
public class LeetCode209_medium_MinSizeSubArraySum {
	
	// O(nlogn) solution
	 public int minSubArrayLen(int s, int[] nums) {
		 if (nums == null || nums.length == 0) {
			 return 0;
		 }
		 
		 int sum = 0;
		 int[] sums = new int[nums.length+1];
		 
		 for (int i = 0; i < nums.length; i++) {
			 sum += nums[i];
			 sums[i+1] = sum; // idx 0, +++, idx i		 
		 }
		 
		 int minLen = -1;
		 for (int start = 0; start < nums.length; start++) {
			 int end = findEnd(s, sums, nums, start);
			 if (end == -1) {
				 break;
			 }
			 
			 int curLen = end-start+1;
			 minLen = minLen == -1 ? curLen : Math.min(curLen, minLen);
		 }
		 
		 return minLen == -1 ? 0 : minLen;
	 }
	 
	 // return end
	 private int findEnd(int s, int[] sums, int[] nums, int start) {
		 int lo = start, hi = nums.length-1;
		 while (lo+1 < hi) {
			 int mid = lo+(hi-lo)/2;
			 int sum = sums[mid+1] - sums[start];
			 if (sum >= s) {
				 hi = mid;
			 } else {
				 lo = mid;
			 }
		 }
		 
		 int sumLo = sums[lo+1] - sums[start];
		 int sumHi = sums[hi+1] - sums[start];
		 
		 if (sumLo >= s) {
			 return lo;
		 } else if (sumHi >= s) {
			 return hi;
		 } else {
			 return -1; 
		 }
	 }
	
	 // O(n) solution.
//    public int minSubArrayLen(int s, int[] nums) {
//    		if (nums == null || nums.length == 0) {
//    			return 0;
//    		}
//    		
//    		int i = 0, j = 0, sum = 0;
//    		int minLength = -1;
//    	
//    		for (;i < nums.length; i++) {
//    			
//    			if (i > 0) { // update sum
//    				sum -= nums[i-1];
//    			}
//    			
//    			// find j
//    			for (;j < nums.length; j++) {
//    				if (sum >= s) {
//    					break;
//    				}
//    				// otherwise step forward
//    				sum += nums[j];
//    			}
//    			
//    			if (sum < s) {
//    				// couldn't find a short length
//    				return minLength == -1 ? 0 : minLength;
//    			} else {
//    				int curLen = j-i;
//    				minLength = minLength == -1 ? curLen : Math.min(minLength, curLen);    				
//    			}
//    		}
//    		
//    		return minLength;
//    }

}
