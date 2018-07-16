package algorithm_HashTable;

// 做前： MxK KxN complexity: MxKxN
// sparse matrix, 存coordinates和val 
// 矩阵A的[i, j] entry B的[j,k]
// 用hashmap表示key A元素的col，val表示【row, val】
// key b元素的row， val表示【col，val】

// 做后，思路和答案有点像，不过最后还是用下面的方法比较快
public class LeetCode311_SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] result = new int[m][nB];
        
        for (int i = 0; i < m; i++) {
        		for (int j = 0; j < n; j++) {
        			if (A[i][j] != 0) {
        				for (int k = 0; k < nB; k++) {
        					result[i][k] += A[i][j] * B[j][k]; // 其实就是C_ik = SUM_j{Aij*Bjk}
        				}
        			}
        		}
        }
        return result;
    }
}
