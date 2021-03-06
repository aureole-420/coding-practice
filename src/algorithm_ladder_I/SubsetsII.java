package algorithm_ladder_I;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * with duplication
 * When enumeration for possible values, only use duplicate elements once.
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		
        // CORNER CASE ------------- !!!
    		if (nums == null || nums.length == 0) {
    			return result;
    		}
    		
    		Arrays.sort(nums);
    		
    		backtrack(nums, 0, list, result);
    		return result;
    }
    
    
    private void backtrack(int[] nums, int d, List<Integer> list, List<List<Integer>> res) {
    		res.add(new ArrayList<Integer>(list));
    		
    		for (int i = d; i < nums.length; i++) { // enumerate all possible values at dimension d
    			if (i-1 >= d) {	// the previous one in nums[] may also be enumerated
    				if (nums[i] == nums[i-1]) continue; // current nums[i] will not be repeatedly enumerated.
    			}
    			list.add(nums[i]);
    			backtrack(nums, i+1, list, res);
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
		int[] S = new int[] {1,2,2};
		SubsetsII ss = new SubsetsII();
		List<List<Integer>> result = ss.subsetsWithDup(S);
		for (List<Integer> list : result) {
			ss.printList(list);
		}
    }	
}
