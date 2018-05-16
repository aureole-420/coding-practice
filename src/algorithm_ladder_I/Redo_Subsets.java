package algorithm_ladder_I;

import java.util.LinkedList;
import java.util.List;

// S = [1,2,3]
// [[], [1],[1,2],[1,2,3],[2],[3]]
public class Redo_Subsets {
	
	public List<List<Integer>> subset(int[] nums) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		List<Integer> list = new LinkedList<Integer>();
		
		dfs(nums, 0, list, result);
		return result;
	}
	
	// deal with 
	private void dfs(int[] nums, int pos, List<Integer> list, List<List<Integer>> result) {
		// base case:
		if (pos > nums.length) { // pos == nums.length => sequences ended with nums[pos-1]被收录，所以不能在这里去掉。
			return;
		}
		result.add(new LinkedList<Integer>(list));
		
		System.out.println(nums.length);
		System.out.println("pos" + pos);
		for (int i = pos; i < nums.length; i++) {
			System.out.println("new elem " + nums[i]);
			list.add(nums[i]);
			dfs(nums, i+1, list, result);
			list.remove(list.size()-1);
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
		int[] nums = new int[] {1,2};
		Redo_Subsets rs = new Redo_Subsets();
		List<List<Integer>> subsets = rs.subset(nums);
		rs.printSubsets(subsets);
	}

}
