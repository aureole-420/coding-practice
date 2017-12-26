package algorithm_ladder_I;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsII {
	
	private Map<Integer, Integer> possibleElem;
    public List<List<Integer>> permuteUnique(int[] nums) {
    	    List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		
		// CORNER CASE ------------- !!!
		if (nums == null) {
			return result;
		}
		
		Arrays.sort(nums);
		possibleElem = new HashMap<>();
		for (int i : nums) {
			possibleElem.put(i, possibleElem.getOrDefault(i, 0) + 1); 
		}
		
		backtrack(nums, list, result);
		return result;
    }
    
    // @Param d dimension
    private void backtrack(int[] nums, List<Integer> list, List<List<Integer>> res) {
    		if (list.size() == nums.length) {
    			res.add(new ArrayList<Integer>(list));
    			return;
    		}
    		
    		for (int elem : possibleElem.keySet()) {
    			if (possibleElem.get(elem) <= 0) continue;
    			list.add(elem); possibleElem.put(elem, possibleElem.get(elem) - 1);
    			backtrack(nums, list, res);
    			list.remove(list.size()-1); possibleElem.put(elem, possibleElem.get(elem) + 1);
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
		PermutationsII ss = new PermutationsII();
		List<List<Integer>> result = ss.permuteUnique(S);
		for (List<Integer> list : result) {
			ss.printList(list);
		}
    }
}
