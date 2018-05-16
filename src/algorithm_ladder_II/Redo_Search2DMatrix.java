package algorithm_ladder_II;

public class Redo_Search2DMatrix {
	
	public boolean searchMatrix(int[][] matrix, int target) {
		// corner case;
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		
		// m row, n column
		int m = matrix.length;
		int n = matrix[0].length;
		
		int lo = 0, hi = m-1;
		while (lo+1 < hi) {
			int mid = lo + (hi - lo) / 2;
			if (target < matrix[mid][0]) {
				hi = mid;
			} else if (matrix[mid][0] == target) {
				return true;
			} else { // if (matrix[mid][0] < target)
				lo = mid;
			}
		}
		
		int RowToSearch;
		if (target < matrix[lo][0]) {
			return false;
		} else if (target >= matrix[lo][0] && target < matrix[hi][0]) {
			RowToSearch = lo;
		} else {
			RowToSearch = hi;
		}
		
		System.out.println(RowToSearch);
		
		// search rows
		lo = 0; hi = n-1;
		while (lo+1 < hi) {
			int mid = lo + (hi - lo) / 2;
			if (target < matrix[RowToSearch][mid]) {
				hi = mid;
			} else if (target > matrix[RowToSearch][mid]) {
				lo = mid;
			} else {
				return true;
			}
		}
		
		if (matrix[RowToSearch][lo] == target || matrix[RowToSearch][hi] == target) {
			return true;
		}
		return false;
	
	}
	
	public static void main(String[] args) {
		int[][] A = new int[3][4];
		A[0] = new int[] {1,2,5,7};
		A[1] = new int[] {10,11,16,20};
		A[2] = new int[] {23,30,34,50};
		int target = 100;
		Redo_Search2DMatrix sd = new Redo_Search2DMatrix();
		System.out.println(sd.searchMatrix(A, target)); // should be true

	}
}
