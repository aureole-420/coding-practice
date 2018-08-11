package algorithm_dp;
import java.util.*;

// 做前 感觉应该用 List[i][j] ? 但 1，2，3，4 怎么做？【1，2，3】中有 【1，2】， 【1，3】两个lds？

// 做中： 看了答案

// 这题超好！！！！

// 其实有一点，这题跟dp没关系的地方，
// subset内互相， 说明结果跟原来array的顺序没关系
// 所以可以先排序，排序后的结果就是：
// s1, s2, s3,...只需要si是si-1的倍数，si自然就是之前所有的倍数
// 这样子就把【互相的问题】转化成了一个只对前一个依赖的题！

// 第二点，用一个pre矩阵记住前一个的index
// 明早起来做。

// count[i] len of LDS, with the ith number as 
// init count[i] = 1;
// transition: count[i], for j < i, if nums[i] % nums[j] == 0 && 1+count[j] > count[i]
//             count[i] = count[j]+1

// 
public class LeetCode368_medium_LargestDivisbleSubset {
	
    public List<Integer> largestDivisibleSubset(int[] nums) {
    	int n = nums.length;
    	int[] count = new int[n];
    	int[] pre = new int[n];
        Arrays.sort(nums);
        
        int maxLen = 0, idx = -1;
        for (int i = 0; i < n; i++) {
        	count[i] = 1;
        	pre[i] = -1;
        	
        	for (int j = i-1; j >=0; j--) {
        		if (nums[i] % nums[j] == 0) {
        			if (1 + count[j] > count[i]) {
        				count[i] = 1 + count[j];
        				pre[i] = j;
        			}
        		}
        	}
        	
        	if (count[i] > maxLen) {
        		maxLen = count[i];
        		idx = i; // the index of the LDS
        	}
        }
        
        List<Integer> ans = new ArrayList<>();
        while (idx != -1) {
        	ans.add(nums[idx]);
        	idx = pre[idx]; // the previous one.
        }
        
        return ans;
    }
}
