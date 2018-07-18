package algorithm_dp;
import java.util.*;

// 自底而上的dp
// 1. state: f[x][y], min path sum from (x,y) to bottom
// 2. initialization: 
// 3. transmission: f[x][y] = A[x][y] + min(f[x+1][y], f[x+1][y+1])
// 4. result: f[0][0]

// O(n^2) space, O(n) if 滚动数组
public class LeetCode120_medium_Triangle {
	
	
	// 滚动数组优化：
  public int minimumTotal(List<List<Integer>> triangle) {
	int N = triangle.size();
	
	// state:
    int[] f = new int[N];
    
    // init:
    for (int j = 0; j < N; j++) {
    	f[j] = triangle.get(N-1).get(j); 
    }
    
    // transmission;
    for (int i = N-2; i >= 0; i--) {
    	for (int j = 0; j < i+1; j++) {
    		f[j] = triangle.get(i).get(j) + Math.min(f[j], f[j+1]);
    	}
    }
    
    return f[0];
}
	
//    public int minimumTotal(List<List<Integer>> triangle) {
//    	int N = triangle.size();
//    	
//    	// state:
//        int[][] f = new int[N][N];
//        
//        // init:
//        for (int j = 0; j < N; j++) {
//        	f[N-1][j] = triangle.get(N-1).get(j); 
//        }
//        
//        // transmission;
//        for (int i = N-2; i >= 0; i--) {
//        	for (int j = 0; j < i+1; j++) {
//        		f[i][j] = triangle.get(i).get(j) + Math.min(f[i+1][j], f[i+1][j+1]);
//        	}
//        }
//        
//        return f[0][0];
//    }
    
}
