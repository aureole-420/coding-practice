package algorithm_dp;
import java.util.*;

// 做前，想到了记忆化搜索。

// 做了半天，也不是做不出来，而是做得太麻烦了。

// 第一高票答案真是好，
public class LeetCode446_hard_ArithmeticSlices_II_SubSequence {
	public int numberOfArithmeticSlices(int[] A) {
		HashMap<Integer, Integer>[] map = new HashMap[A.length];
		int res = 0;
		
		
		for (int i = 0; i < A.length; i++) {
			map[i] = new HashMap<>();
			
			for (int j = 0; j < i; j++) {
				long diff = (long) A[i] - A[j];
				if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;
				
				int d = (int) diff;
				int c1 = map[i].getOrDefault(d, 0);
				int c2 = map[j].getOrDefault(d, 0);
				res += c2; 
				map[i].put(d, c1 + c2 + 1); // 1 is two-number subsequence, that will NOT be counted to result;
			}
		}
		
		return res;
	}
//	ResultType {
//		int nei
//		int root;
//		
//	}
//    public int numberOfArithmeticSlices(int[] A) {
//    	 HashMap<String, Integer> map = new HashMap<>();
//    	 int ans = 0;
//    	 for (int i = 0; i < A.length; i++) {
//    		 ans += dfs(A, i, 0, true, map);
//    	 }
//    	 
//    	 return ans;
//    }
//    
//    // isRoot == true: return number of subsequence by...
//    // isRoot == true: return -1, no subsequence and no == diff
//    //                 return 0, no subseqeunce but has == diff
//    private int dfs(int[] A, int i, int diff, boolean isRoot, HashMap<String, Integer> map) {
//    	int ans = 0;
//    	// isRoot
//    	if (isRoot) {
//    		for (int j = i+1; j < A.length; j++) {
//    			int curDiff = A[i] - A[j];
//    			int temp = dfs(A, j, curDiff, false, map);
//    			if (temp >= 0) {
//    				ans += 1 + temp;
//    			}
//    		}
//    		return ans;
//    	}
//    	
//    	// not root
//    	if (map.containsKey(i+"@"+diff)) return map.get(i+"@"+diff);
//    	int foundDiff = 0;
//    	for (int j = i+1; j < A.length; j++) {
//    		int curDiff = A[i] - A[j];
//    		if (curDiff == diff) {
//    			foundDiff++;
//    			int temp = dfs(A, j, diff, false, map);
//    			ans += temp < 0 ? 0 : temp;
//    		}		
//    	}
//    	if (foundDiff) {
//    		return -1;
//    	} 
//    }
}
