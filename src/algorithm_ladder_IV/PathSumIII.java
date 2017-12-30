package algorithm_ladder_IV;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * Leetcode 437
 * Very similar to subsets
 */
public class PathSumIII {
	class ResultType {
		ArrayList<LinkedList<Integer>> pathsFromCurrentNode;
		ArrayList<LinkedList<Integer>> pathsNotFromCurrentNode;
		ResultType(ArrayList<LinkedList<Integer>> pathsFromCurrentNode, ArrayList<LinkedList<Integer>> pathsNotFromCurrentNode) {
			this.pathsFromCurrentNode = pathsFromCurrentNode;
			this.pathsNotFromCurrentNode = pathsNotFromCurrentNode;
		}
	}
	
	private ArrayList<LinkedList<Integer>> allPaths = new ArrayList<LinkedList<Integer>>();
	private int sum;
	public int pathSum(TreeNode root, int sum) {
		this.sum = sum;
		ResultType r = findPaths(root);
		for (LinkedList<Integer> p : r.pathsFromCurrentNode) {checkPath(p);}
		for (LinkedList<Integer> p : r.pathsNotFromCurrentNode) {checkPath(p);}
		printPaths(allPaths); // testing
		return allPaths.size();
	}
	
	private ResultType findPaths(TreeNode root) {
		ArrayList<LinkedList<Integer>> pfcn = new ArrayList<LinkedList<Integer>>();
		ArrayList<LinkedList<Integer>> pNfcn = new ArrayList<LinkedList<Integer>>();
		if (root == null) {
			return new ResultType(pfcn, pNfcn);
		}
		
		ResultType left = findPaths(root.left);
		ResultType right = findPaths(root.right);
		
		for (LinkedList<Integer> p : left.pathsFromCurrentNode) pNfcn.add(new LinkedList<Integer>(p));
		for (LinkedList<Integer> p : left.pathsNotFromCurrentNode) pNfcn.add(new LinkedList<Integer>(p));
		for (LinkedList<Integer> p : right.pathsFromCurrentNode) pNfcn.add(new LinkedList<Integer>(p));
		for (LinkedList<Integer> p : right.pathsNotFromCurrentNode) pNfcn.add(new LinkedList<Integer>(p));
		
		for (LinkedList<Integer> p : left.pathsFromCurrentNode) {
			p.addFirst(root.val);
		}
		for (LinkedList<Integer> p : right.pathsFromCurrentNode) {
			p.addFirst(root.val);
		}
		pfcn.addAll(left.pathsFromCurrentNode);
		pfcn.addAll(right.pathsFromCurrentNode);
		LinkedList<Integer> temp = new LinkedList<Integer>(); temp.add(root.val);
		pfcn.add(temp);
		return new ResultType(pfcn, pNfcn);
	}
	
	private void checkPath(LinkedList<Integer> path) {
		int total = 0;
		for (int i : path) 
			total += i;
		if (total == sum) 
			allPaths.add(path);
	}
	
	private void printPaths(ArrayList<LinkedList<Integer>> allPaths) {
		for (LinkedList<Integer> path: allPaths) {
			for (int i : path) {
				System.out.print(i + "->");
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode left = new TreeNode(5);
		TreeNode right = new TreeNode(-3);
		left.left = new TreeNode(3); left.right = new TreeNode(2);
		left.left.left = new TreeNode(3); left.left.right = new TreeNode(-2);
		left.right.right = new TreeNode(1);
		right.right = new TreeNode(11);
		root.left = left; root.right = right;
		
		PathSumIII p = new PathSumIII();
		System.out.println(p.pathSum(root, 1)); // should be 3	
	}
	
}
