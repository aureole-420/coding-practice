package algorithm_dp;

import java.util.Arrays;

// 做前： f[i], amount = i, 可以最少用多少枚硬币
// f[i] = min{f[j] + f[i-j]}, if f[j] 。。。

// 看了答案：
// 不是所有j都可以，j就是coins里面的那几个
// i.e. f[i] = min{f[c_j] + f[i-c_j]} = min{f[i-c_j]} + 1
public class LeetCode322_medium_CoinChange {
	
    public int coinChange(int[] coins, int amount) {
    	
        int[] f = new int[amount+1];
        
        Arrays.fill(f, amount+1);
        
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
        	for (int j = 0; j < coins.length; j++) {
        		if (coins[j] <= i) {
        			f[i] = Math.min(f[i], f[i-coins[j]] + 1);
        		}        		
        	}
        }
        
        return f[amount] > amount ? -1 : f[amount];
    }
}
