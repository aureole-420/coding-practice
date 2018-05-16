package algorithm_ladder_I;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Redo_SubsetII {
	public List<List<Integer>> subset(int[] nums) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		List<Integer> list = new LinkedList<Integer>();
		
		Arrays.sort(nums);
		
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
		
//		System.out.println(nums.length);
//		System.out.println("pos" + pos);
		for (int i = pos; i < nums.length; i++) {
//			System.out.println("new elem " + nums[i]);
			if (i != pos && i-1 >= 0) { // 已有序列<A,B,C>, 待iterate序列<C,C,...,D,D>, 放第一个，不iterate第二个开始重复的。
				if (nums[i-1] == nums[i]) {
					continue;
				}
			}
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
		int[] nums = new int[] {2,1,2};
		Redo_SubsetII rs = new Redo_SubsetII();
		List<List<Integer>> subsets = rs.subset(nums);
		rs.printSubsets(subsets);
	}

}
