package algorithm_ladder_I;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
    		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		
		// CORNER CASE ------------- !!!
		if (nums == null) {
			return result;
		}
		
		Arrays.sort(nums);
		
		backtrack(nums, 0, list, result);
		return result;
    }
    
    // @Param d dimension
    private void backtrack(int[] nums, int d, List<Integer> list, List<List<Integer>> res) {
    		if (list.size() == nums.length) {
    			res.add(new ArrayList<Integer>(list));
    			return;
    		}
    		
    		for (int i =  0; i < nums.length; i++) {
    			if (list.contains(nums[i])) continue;
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
		int[] S = new int[] {1,2,3};
		Permutations ss = new Permutations();
		List<List<Integer>> result = ss.permute(S);
		for (List<Integer> list : result) {
			ss.printList(list);
		}
    }
}
