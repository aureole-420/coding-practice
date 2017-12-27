package algorithm_ladder_II;

public class Search2DMatrix {
	
	public boolean searchMatrix(int[][] matrix, int target) {
        // corner case:
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		
		int[] rowHead = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			rowHead[i] = matrix[i][0];
		}
		
		int[] searchRow = binarySearch(rowHead, target);
		if (searchRow.length == 1) {
			return true;
		}
		int loValue = matrix[searchRow[0]][0], hiValue = matrix[searchRow[1]][0];
		int theRowToSearch = -1;
		if (target == loValue || target == hiValue) return true;
		if (loValue > target) {
			return false;
		} else if (target > hiValue) {
			theRowToSearch = searchRow[1];
		} else {
			theRowToSearch = searchRow[0];
		}
		
		System.out.println("the row to search: " +theRowToSearch);
		int[] result = binarySearch(matrix[theRowToSearch], target);
		if (result.length == 1) return true;
		loValue = matrix[theRowToSearch][result[0]]; 
		hiValue = matrix[theRowToSearch][result[1]];
		if (target == loValue || target == hiValue) return true;
		return false;
    }
	
	private int[] binarySearch (int[] A, int target) {
		int lo = 0, hi = A.length -1;
		while (lo+1 < hi) {
			int mid = lo + (hi-lo) / 2;
			if (A[mid] == target) {
				return new int[] {mid};
			} else if (target > A[mid]) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		return new int[] {lo, hi};
	}
	
	public static void main(String[] args) {
		int[][] A = new int[3][4];
		A[0] = new int[] {1,2,5,7};
		A[1] = new int[] {10,11,16,20};
		A[2] = new int[] {23,30,34,50};
		int target = 3;
		Search2DMatrix sd = new Search2DMatrix();
		System.out.println(sd.searchMatrix(A, target)); // should be true

	}
	
	
	
}
