package algorithm_ladder_I;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Redo_PermutationsII {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		List<Integer> list = new LinkedList<Integer>();
		
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		for (int i = 0; i < used.length; i++) {
			used[i] = false;
		}
		
		dfs(nums, used, 0, list, result);
		return result;
	}

	
	private void dfs(int[] nums, boolean[] used, int pos, List<Integer> list, List<List<Integer>> result) {
		if (list.size() == nums.length) {
			result.add(new LinkedList<Integer>(list));
			return;
		}
		
		Set<Integer> uniqueElem = new HashSet<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) { // if not used
				if (uniqueElem.contains(nums[i])) { // for every position, nums[i] only occurs once
					continue;
				} else {
					uniqueElem.add(nums[i]);
				}
				list.add(nums[i]);
				used[i] = true;
				dfs(nums, used, i+1, list, result);
				list.remove(list.size() - 1);
				used[i] = false;
			}
		}		
	}
	
	public void printSubsets(List<List<Integer>> subsets) {
		System.out.println("[");
		for (List<Integer> sets : subsets) {
			System.out.print("[");
			String line = "";
			for (Integer elem : sets) {
				line = line + elem + " ";				
			}
			System.out.print(line.trim());
			System.out.print("]" + "\n");
		}
		System.out.println("]");
			
	}
	
	
	public static void main(String[] args) {
		Redo_PermutationsII rp = new Redo_PermutationsII();
		int[] nums = new int[] {1,2,2};
		List<List<Integer>> result = rp.permute(nums);
		
		rp.printSubsets(result);
	}
}
