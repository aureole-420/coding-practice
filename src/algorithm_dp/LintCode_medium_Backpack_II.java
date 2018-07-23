package algorithm_dp;

// given n items with size A[i] and value V[i], and backpack with size m, whats the maximum value can you put into th backpack
// ---体积满足条件，value取胜
// A = [2,3,5,7], V= [1,5,2,4]， m = 10, the maximum value sum is 9 = V[2] + V[4]

// states: f[i][j], 前i个物品中，去除“若干”物品后，体积正好为j的最大价值。
// init: f[i][0] = 0, f[0][1...m] = -inf ---取不到的情况！！！
// transfer function: f[i][j] = (1) f[i-1][j] if A[i] > j
//								(2) if A[i] <= j  max(f[i-1][j], f[i-1][j-a[i]] + v[i])
// answer: f[len(A)][1...m]中的最大值 --- 各个体积下的最大值
public class LintCode_medium_Backpack_II {
	
	public int backPackII(int m , int[] A, int[] V) {
		int n = A.length;
		
		// state
		int[][] f = new int[n+1][m+1];
		
		// init
		for (int i = 0; i <= n; i++) {
			f[i][0] = 0;
		}
		for (int j = 1; j <= m; j++) {
			f[0][j] = Integer.MIN_VALUE;
		}
		
		// function:
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (A[i-1] > j) {
					f[i][j] = f[i-1][j];
				} else {
					f[i][j] = Math.max(f[i-1][j],  f[i-1][j-A[i-1]]+V[i-1]);
				}
			} // for j
		} // for i
		
		// answer
		int res = Integer.MIN_VALUE;
		for (int size = 1; size <= m; size++) {
			res = Math.max(res,  f[n][size]);
		}
		
		return res;
	}
	
	
	public static void main(String[] args) {
		int[] A = new int[] {2,3,5,7};
		int[] V = new int[] {1,5,2,4};
		LintCode_medium_Backpack_II bp2 = new LintCode_medium_Backpack_II();
		
		System.out.println(bp2.backPackII(10, A, V)); // should be 9
	}
}
