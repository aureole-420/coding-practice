package algorithm_HashTable;
import java.util.*;
// 做前： 没思路，只想到了每个元素往前查询，

// 做前2: 仔细分析过程73 74 75 71 69 72 76 73
// 维持一个递减堆，堆里放index

// 做后： 哇哇哇！！！我居然自己figure out出来要实现递减堆！！！！而且beats90%的codes
public class LeetCode739_medium_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
    		// corner case
        if (temperatures == null || temperatures.length == 0) {
        		return new int[0];
        } 
        
        // at least one element in array
        int[] firstWarmer = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        
        for (int idx = 1; idx < temperatures.length; idx++) {
        		while (!stack.isEmpty() && temperatures[idx] > temperatures[stack.peek()]) {
        			firstWarmer[stack.pop()] = idx;
        		}
        		stack.push(idx);
        }
        
        while (!stack.isEmpty()) {
        		firstWarmer[stack.pop()] = -1;
        }
        
        int[] result = new int[temperatures.length];
        for (int i = 0; i < result.length; i++) {
        		if (firstWarmer[i] < 0) {
        			result[i] = 0;
        		} else {
        			result[i] = firstWarmer[i]-i;
        		}	
        }
        
        return result;      
    }
}
