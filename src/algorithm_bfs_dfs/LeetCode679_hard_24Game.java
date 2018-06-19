package algorithm_bfs_dfs;
import java.util.*;

// https://leetcode.com/problems/24-game/description/
// 做前： 现在想到的就是遍历所有可能运算，因为只有二元运算符能够把两个数变成一个数，总共四个数，需要三个二元运算符？
// 做前2: 看了一下discussion，确实跟我想得差不多， 3个二元运算符， 第一次P(4,2), 第二次P(3,2), 第三次P(2,2),每次 4种运算符（+,-,*,/）
// 做中：要点： 1. 全排列， P(k,2)  2. dfs的回溯（backtracking）
public class LeetCode679_hard_24Game {
    public boolean judgePoint24(int[] nums) {
    		if (nums == null || nums.length != 4) {
    			return false;
    		}
    		
    		ArrayList<Double> list = new ArrayList<>();
    		for (int num : nums) {
    			list.add(1.0 * num);
    		}
    		
    		return dfs(list);
    }
    
    // Assume list has K elements
    // if K == 1: check == 24
    // else, choose 2 from K for binary operation.
    private boolean dfs(ArrayList<Double> list) {
    		if (list.size() == 1) {
    			if (Math.abs(list.get(0) - 24.0) < 1e-6) {
    				return true;
    			} else {
    				return false;
    			}
    		}
    		
    		for (int i = 0; i < list.size(); i++) {
    			for (int j = 0; j < list.size(); j++) {
    				if (i == j) continue;
    				
    				ArrayList<Double> list2 = new ArrayList<>();
    				for (int k = 0; k < list.size(); k++) {
    					if (k != i && k != j) {
    						list2.add(list.get(k));
    					}
    				}
    				
    				// k = 1 add operation +
    				// k = 2 multiplication operation *
    				// k = 3 minus operation -
    				// k = 4 quotient operation /
    				for (int k = 1; k <=4; k++) {
    					if (k <= 2 && i > j) { // 去重
    						continue;
    					}
    					
    					
    					if (k == 1) {
    						list2.add(list.get(i) + list.get(j));
    					} else if (k == 2) {
    						list2.add(list.get(i) * list.get(j));
    					} else if (k == 3) {
    						list2.add(list.get(i) - list.get(j));
    					} else {
    						if (list.get(j) == 0) {
    							continue;
    						} else {
    							list2.add(list.get(i) / list.get(j));
    						}
    					}
    					
    					if (dfs(list2)) {
    						return true;
    					}
    					
    					list2.remove(list2.size()-1);
    				}
    			}
    		}
    		
    		return false;
    }
    
    public static void main(String[] args) {
    		LeetCode679_hard_24Game game = new LeetCode679_hard_24Game();
//    		int[] nums = new int[] {4,1, 8, 7};
    		int[] nums = new int[] {1,2,1,2};

    		System.out.println(game.judgePoint24(nums));
    		
    		ArrayList<Integer> arr = new ArrayList<>();
    		for (int i = 0; i < 5; i++) arr.add(i);
    		
    		System.out.println(arr.remove(2));
    		System.out.println(arr.remove(2));
    }
}
