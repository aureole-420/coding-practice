package algorithm_ladder_I;

import java.util.ArrayList;
import java.util.List;

/**
 * lintcode 17 medium
 * use dfs:
 */
public class Subsets {
	
    public List<List<Integer>> subsets(int[] nums) {
    	
    		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		
        // CORNER CASE ------------- !!!
    		if (nums == null || nums.length == 0) {
    			return result;
    		}
    	
    		backtrack(nums, 0, list, result);
    		return result;
    }
    
    // d for dimension/position
    private void backtrack(int[] nums, int d, List<Integer> list, List<List<Integer>> res) {
    		res.add(new ArrayList<Integer>(list));
    		
    		for (int pos = d; pos < nums.length; pos++) { // all possible values: ranging from nums[d] to nums[nums.length-1]
    			list.add(nums[pos]);
    			backtrack(nums, pos+1 ,list, res);
    			list.remove(list.size()-1);
    		}
    }

    
    public void printList(List<Integer> list) {
    		System.out.print("[");
    		for (int i : list) {
    			System.out.print(i + " ");
    		}
    		System.out.print("] \n");
    }
    
    public static void main(String[] args) {
    		int[] S = new int[] {1,2,3};
    		Subsets ss = new Subsets();
    		List<List<Integer>> result = ss.subsets(S);
    		for (List<Integer> list : result) {
    			ss.printList(list);
    		}
    }	
}
