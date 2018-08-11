package algorithm_dp;
import java.util.*;

// 做前： 用记忆化搜索的办法
// hashmap<Integer, Boolean>[],  
// stone[1]: step size 1, true 


// 做后，对[1,2,2^31]有一个corner case， 千万别让k++溢出！！！
// 其实我用的还是dp，
public class LeetCode403_hard_FrogJump {
	
    public boolean canCross(int[] stones) {
    	
        int N = stones.length;
        HashSet<Integer>[] possibleWays = (HashSet<Integer>[]) new HashSet[N];
        for (int i = 0; i < N; i++) {
        	possibleWays[i] = new HashSet<Integer>();
        }
        possibleWays[0].add(-1);
        
        for (int i = 1; i < N; i++) {
        	
        	if (i-1 == 0) { // previous one is the first stone
        		if (stones[1] == 1) {
        			possibleWays[i].add(1);
        		} else {
        			return false; // first step can only be 1
        		}
        	}
        	
        	for (int j = 1; j < i; j++) {
        		int dist = stones[i] - stones[j];
        		System.out.println(dist);
        		for (int k = dist-1; k < Integer.MAX_VALUE && k <= dist+1; k++) { // can jump dist steps, from stone j -> stone i
        			System.out.println(k);
            		if (possibleWays[j].contains(k)) {
            			possibleWays[i].add(dist);
            		}
            	}
        	}
        }
        
        if (possibleWays[N-1].size() > 0) {
        	return true;
        }
        return false;    
    }
    
    public static void main(String[] args) {
    	int[] arr = new int[] {0,1,2147483647};
    	LeetCode403_hard_FrogJump fj = new LeetCode403_hard_FrogJump();
    	System.out.println(fj.canCross(arr));
    	
    }
    
}
