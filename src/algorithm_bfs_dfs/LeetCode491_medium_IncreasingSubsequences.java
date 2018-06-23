package algorithm_bfs_dfs;
import java.util.*;

// 我觉得这题就是subset

// 做中，有个test case总是通不过：[1,2,3,...,10,1,1,1,1]

//https://leetcode.com/problems/increasing-subsequences/discuss/97147/Java-solution-beats-100

// 做后： 难点是【无序情况下的】去重！！！
// backtrack内部用set<Integer> used的做法也适用于subset题
public class LeetCode491_medium_IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
        		return result;
        }
        
//        Arrays.sort(nums);
        
        List<Integer> list = new LinkedList<>();
        backtrack(nums, 0, result, list);
        return result;
    }
    
    private void backtrack(int[] nums, int i, List<List<Integer>> result, List<Integer> list) {	
    		if (list.size() >= 2) {
    			result.add(new ArrayList<Integer>(list));
    		}
    		
    		if (i >= nums.length) {
    			return;
    		}
    		
		// 去重参考了：
		//https://leetcode.com/problems/increasing-subsequences/discuss/97147/Java-solution-beats-100
		HashSet<Integer> used = new HashSet<>();
		
    		for (int possibleIndex = i; possibleIndex < nums.length; possibleIndex++) {
    			/*  !!!! 这里去重和subset不一样，subset是sorted array，所以这样写没问题！
    			 * 但这里并没有排序！
    			 * 需要用
    			if (possibleIndex > i && nums[possibleIndex-1] == nums[possibleIndex]) {
    				continue;
    			}
    			*/
    			
    			if (used.contains(nums[possibleIndex])) {
    				continue;
    			} 
    			
    			
    			if (list.size() > 0 && nums[possibleIndex] < list.get(list.size()-1)) {
    				continue;
    			}
    				
    			list.add(nums[possibleIndex]);
    			used.add(nums[possibleIndex]);
    			backtrack(nums, possibleIndex+1, result, list);
    			list.remove(list.size()-1);
    		}
    }
    
    
}
