package algorithm_ladder_V;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// LinkedList 有 addFirst！ ---- LIST API并没有addFirst
// List add(idx, item), 不断调用List.add(0, item) 就是addFirst
public class LeetCode107_LevelOrderTraversal_II {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		iterate(root, 0, res); // add(res.size()-level, root.val)
		return res;
	}
	
	private void iterate(TreeNode root, int level, List<List<Integer>> res) {
		if (root == null) {
			return;
		}
		
		if (level >= res.size()) {
			res.add(0, new ArrayList<Integer>());
		}
		res.get(res.size()-level-1).add(root.val); // 实际在res的idx + level == res.size()-1
		
		iterate(root.left, level+1, res);
		iterate(root.right, level+1, res);
		return;
	}
	
	public void printList(List<Integer> list) {
		System.out.println("result:");
		for (int i : list) 
			System.out.print(i + " ");
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
//		List<List<Integer>> res = new LinkedList<List<Integer>>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		List<Integer> l1 = new LinkedList<Integer>();
		l1.add(1);
		List<Integer> l2 = new LinkedList<Integer>();
		l2.add(2);
		res.add(0, l1);
		res.add(0, l2);
		
		LeetCode107_LevelOrderTraversal_II ll = new LeetCode107_LevelOrderTraversal_II();
		ll.printList(res.get(0));
		ll.printList(res.get(1));
		System.out.println("num of sublist: " + res.size());
	}
}
