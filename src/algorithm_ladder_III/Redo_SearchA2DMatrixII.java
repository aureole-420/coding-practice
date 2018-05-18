package algorithm_ladder_III;

public class Redo_SearchA2DMatrixII {
	
	public int searchMatrix(int[][] A, int target) {
		// interestingly,why start from left bottom and only go UP and RIGHT will do?
		// check myself this evening.
		return 1;
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
