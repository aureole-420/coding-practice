package algorithm_ladder_III;

/**
 * leetcode 240
 */
public class SearchA2DMatrixII {
	public int searchMatrix(int[][] A, int target) {
        // corner case 
		if (A == null || A.length == 0) 
			return 0;
		
		int i = A.length-1, j = 0; // i^th row, j^th col -- the bottom left corner of the matrix
		int result = 0;
		while (i >= 0 && j < A[0].length) {
			if (A[i][j] > target) {
				i--;
			} else if (A[i][j] < target) {
				j++;
			} else {
				result++;
				i--;
				j++;
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		int[][] A = new int[3][4];
		A[0] = new int[] {1, 3, 5, 7};
		A[1] = new int[] {2, 4, 7, 8};
		A[2] = new int[] {3, 5, 9, 10};
		int target = 3;
		SearchA2DMatrixII s = new SearchA2DMatrixII();
		System.out.println(s.searchMatrix(A, target)); // should be 2	
	}
}
