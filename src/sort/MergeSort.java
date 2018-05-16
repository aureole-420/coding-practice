package sort;

public class MergeSort {
	
	public static void mergeSortRecur(int[] a) {
		sort(a, 0, a.length-1);
	}
	
	private static void sort(int[] a, int lo, int hi) {
		if (lo >= hi) return;
		
		int mid = lo + (hi-lo)/2;
		sort(a, lo, mid); // sort left part
		sort(a, mid+1, hi); // sort right part
		merge(a, lo, mid, hi); // merge
	}
	
	// merge a[lo..mid] with a[mid+1, hi]
	private static void merge(int[] a, int lo, int mid, int hi) {
		int[] aux = new int[a.length];
		for (int i = lo; i <= hi; i++) {
			aux[i] = a[i];
		}
		
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {a[k] = aux[j]; j++;}
			else if (j > hi) {a[k] = aux[i]; i++;}
			else if (aux[i] < aux[j]) {a[k] = aux[i];i++;}
			else {a[k] = aux[j];j++;}
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {5,2,1,7,10,8};
		mergeSortRecur(a);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " "); // should be 1 2 57 8 10
	}
}
