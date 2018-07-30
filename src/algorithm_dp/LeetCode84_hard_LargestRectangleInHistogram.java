package algorithm_dp;

// 这题是因为做85 maximal rectangle时看到大家都说跟84有关才做的。
// 看了答案，两个好方法：1. 分治 2. 递增stack. 
// 分治的原因，找到区间最小，包含该最小值的都会比
//https://leetcode.com/problems/maximal-rectangle/submissions/1
public class LeetCode84_hard_LargestRectangleInHistogram {
	
    public int largestRectangleArea(int[] heights) {
        return helper(heights, 0, heights.length-1);
    }
    
    // 该区间内的最大rectangle
    private int helper(int[] heights, int start, int end) {
    	if (start > end) {
    		return 0;
    	}
    	
    	int idx = start, min = heights[start];
    	for (int i = start; i <= end; i++) {
    		if (heights[i] < min) {
    			idx = i;
    			min = heights[i];
    		}
    	}
    	
    	int curArea = (end - start + 1) * heights[idx]; // 包含min高度的最大面积
    	return Math.max(curArea, Math.max(helper(heights, start, idx-1), helper(heights, idx+1, end)));   	
    }
}
