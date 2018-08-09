package algorithm_dp;


// 不会做，直接看了答案
// 答案太好了
// 解法一：brutal force
// 每一次选择i，那么猜中的数可能在左也可能在右，为了保证猜中，必须选左右cost最大的那个
// 选最好的那个i
// cost(1, n) = Min (any i) {i + MAX(cost(1, i-1), cost(i+1, n)}

// cost(i,j) refers to the min cost of finding the worst number given only the numbers in the range(i,j)
// cost(i,j)
// 按长度来遍历， cost[1,1], [2,2],...[5,5] 
// [1,2], [2,3], [3,4], [4,5]
// [1,3],[2,3],....[3,5]
public class LeetCode375_medium_GuessNumberHigherOrLower_II {
	
	// brutal force
//    public int getMoneyAmount(int n) {
//        return cost(1,n);
//    }
//    
//	public int cost(int lo, int hi) {
//		if (lo >= hi) {
//			return 0;
//		}
//		int minres = Integer.MAX_VALUE;
//		for (int i = lo; i <= hi; i++) {
//			int tempres = i + Math.max(cost(lo, i-1), cost(i+1, hi));
//			minres = Math.min(minres, tempres);
//		}
//		
//		return minres;
//	}
	
	// dp
	public int getMoneyAmount(int n) {
		int[][] cost = new int[n+1][n+1];
		
		// init: len = 1
		// cost[i][i] = 0;
		
		for (int len = 2; len <= n; len++) {
			for (int i = 1; i+len-1 <= n; i++) {//从[1,2]开始，故 i start from 1
				int minres = Integer.MAX_VALUE;
				for (int piv = i; piv +1 <= i+len-1; piv++) { // ！！！ß保证piv+1不越界
					int tempres = piv + Math.max(cost[i][piv-1], cost[piv+1][i+len-1]);
					minres = Math.min(tempres, minres);
				}
				cost[i][i+len-1] = minres;
			}			
		}
		
		return cost[1][n];

	}
	
	
	// cost(1,5) | pivot==3 = 3 + max(cost(1,2), cost(4,5))
	// cost(4,5) = min(4 + 0, 5 +0) = 4
	// so cost(1,5) | pivot==3 = 3 + 4 = 7;
	// cost(1,5)|pivot==4 = 4 + max(cost(1,3), cost(5,5))
	// cost(1,3)|pivot==1 = 1 + cost(2,3) = 1 + 2 = 3
	// cost(1,3)|pivot==3 = 3 + cost(1,2)=3+1=4
	// cost(1,3)|pivot==2 = 2+0 =2
	// so cost(1,3) = 2
	// cost(1,5)|pivot==4 = 4 + 2 = 6 ----- ans
	// cost(1,5)|pivot==5 = 5+cost(1,4)
	// cost(1,4) = min(cost(1,4)|p==1, cost(1,4)|p==2, cost(1,4)|p==3, cost(1,4)|p==4)
	//       = min(.., .., 3+1, 4+2) = 4
	// cost(1,5)|pivot = 5+4 = 9
	public static void main(String[] args) {
		LeetCode375_medium_GuessNumberHigherOrLower_II gs = new LeetCode375_medium_GuessNumberHigherOrLower_II();
		System.out.println(gs.getMoneyAmount(5));
	}
}
