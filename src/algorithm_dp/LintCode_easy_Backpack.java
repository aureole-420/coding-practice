package algorithm_dp;

// 题目，n个物品中挑选若干放入背包，最多能装多满？
// 每个物品大小为A[i]
// e.g. A=[2,3,5,7]
// 背包大小为13，可以选择2，3，7, 最多可以装满12的空间。

// 错误的思维是：f[i] 前i个去除若干，装到m里最大能装多少。

// states: f[i][j] 当背包容量为j，能否从前i个中取出一部分来组成j; 显然 j = 0, 1, ..., m
// init f[i][0] = true; f[0][1...m] = false;
// function: f[i][j] = (1) if A[i] > j, A[i]肯定不能放进背包里 f[i-1][j]
//                     (2) if A[i] <= j, (2.1) A[i] 放进背包 f[i-1][j-A[i]]
//										 (2.2) A[i] 不放进背包 f[i-1][j]
// answer: f[len(A)][j] == true with max j 

// 复杂度O(n*m)
// 空间可以优化到O(m), 毕竟f[i][j]只跟f[i-1]相关。把i的地方全部都mod 2就可以。


// 用backpack II的方法来处理：
// state: f[i][j] 当背包容量为j时，从前i个中取出若干个【体积为j】所能得到的最大值， j=0,1,...m
// init: f[i][0] = 0,  f[0][1...m] = -inf
// tranfer function: f[i][j] = (1) if A[i] > j, f[i-1][j]
//                             (2) if A[i] <= j, MAX(f[i-1][j], f[i-1][j-A[i]] + A[i])
// answer

// 做后，有些混淆，上面fij是体积确确实实为j！！！也可以定位体积小于j，那时初始条件有变化，见https://www.cnblogs.com/googlemeoften/p/5836508.html
public class LintCode_easy_Backpack {
	
	public int backpack(int m, int[] A) { 
		int n = A.length;
		
		// state
		int[][] f = new int[n+1][m+1];
		
		// init
		for (int i = 0; i <= n; i++) {
			f[i][0] = 0;
		}
		for (int j = 1; j <= m; j++) {
			f[0][j] = Integer.MIN_VALUE;
//			f[0][j] = 0; // 这是个坑！！！！不是-inf！！！可以考虑不要i=0这一行，这样就不需要初始化f[0][j]了！！！直接把第一个item带进去得到f[0][j]的值
			// 详见 https://www.cnblogs.com/googlemeoften/p/5836508.html
			// ---- 发现上面的话有问题哈哈哈，其实-inf是对的，表示取不到，定义f[i][j]对应的是实实在在的j volume，不是小于等于j
			// 所以answer应该是从m到1，找最大的f[n][m...1]值。
		}
		
		// f[1][j] = 
		// function
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (A[i-1] > j) {
					f[i][j] = f[i-1][j];
				} else {
					f[i][j] = Math.max(f[i-1][j], f[i-1][j-A[i-1]] + A[i-1]);
				}
				System.out.println("(i,j)=("+i+","+j+"):" + f[i][j]);
			}
		}
		
		 //result
		int res = Integer.MIN_VALUE;
		for (int j = m; j >= 1; j--) {
			res = Math.max(res, f[n][j]);
		}
		return res;
	}
	
//	
//	public int backpack(int m, int[] A) {
//		
//		int n = A.length;
//		
//		// states
//		boolean[][] f = new boolean[n+1][m+1];
//		
//		// init
//		for (int i = 0; i <= n; i++) {
//			f[i][0] = true;
//		}
//		for (int j = 1; j <= m; j++) {
//			f[0][j] = false;
//		}
//		
//		// transfer function:
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= m; j++) {
//				if (A[i-1] > j) {
//					f[i][j] = f[i-1][j];
//				} else {
//					f[i][j] = f[i-1][j-A[i-1]] || f[i-1][j];
//				}
//			} // for j
//		} // for i
//		
//		// answer
//		for (int j = m; j > 0; j--) {
//			if (f[n][j]) {
//				return j;
//			}
//		}
//		
//		return 0;
//	}
	
	
	// 
	public static void main(String[] args) {
		LintCode_easy_Backpack bp = new LintCode_easy_Backpack();
		int[] A = new int[] {2,3,5,7};
		System.out.println(bp.backpack(13, A)); // should be 12
		
	}
}
