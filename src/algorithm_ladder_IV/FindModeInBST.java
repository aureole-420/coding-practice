package algorithm_ladder_IV;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// leetcode 501 
// 思想比较简单，中序遍历即可
// follow up, use no extra space
// https://leetcode.com/problems/find-mode-in-binary-search-tree/discuss/98101/Proper-O(1)-space
// leetcode 很多讨论自称是O(1), 但并不是，比如对1，2，3，。。。, N, N+1, N+1, 会有O(n) extra space
// 正确做法应该是用two pass，first pass findout the highest number of occurances of any value.
// the second pass collect all values occuring that often.
public class FindModeInBST {
    public int[] findMode(TreeNode root) {
        // traverse binary tree in order:
    		HashMap<Integer, Integer> cnt = new HashMap<>();
    		List<Integer> res = new ArrayList<>();
    		
    		dfs(root, cnt);
    		
    		int max_count = 0;
    		for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
    			if (entry.getValue() > max_count) {
    				res.clear();
    				res.add(entry.getKey());
    				max_count = entry.getValue();
    			} else if (entry.getValue() == max_count) {
    				res.add(entry.getKey());
    			}
    		}
    		
    		int[] resArr = new int[res.size()];
    		for (int i = 0; i < res.size(); i++) {
    			resArr[i] = res.get(i);
    		}
    		return resArr;
    }
    
    private void dfs(TreeNode root, HashMap<Integer, Integer> cnt) {
    		// base case
    		if (root == null) {
    			return;
    		}
    		
    		dfs(root.left, cnt);
    		cnt.put(root.val, cnt.getOrDefault(root.val, 0) + 1);
    		dfs(root.right, cnt);
    }
    
    public static void main(String[] args) {
    		TreeNode root = new TreeNode(1);
    		root.right = new TreeNode(2);
    		root.right.left = new TreeNode(2);
    		
    		FindModeInBST f = new FindModeInBST();
    		
    		int[] res = f.findMode(root);
    		for (int m : res) {
    			System.out.println(m); // should be 2
    		}
    		
    }
}
