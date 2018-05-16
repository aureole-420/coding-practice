package sort;

// Iterative version of merge sort
public class MergeSortIter {
	
	public static void mergeSort(int[] a) {
		int N = a.length;
		for (int sz = 1; sz < N; sz = sz * 2) {
			for (int lo = 0; lo < N;) {
				merge(a, lo, lo+sz-1, Math.min(N-1, lo+2*sz-1));
				lo += 2*sz;
			}
		}
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
		int[] a = new int[] {5,2,7,1,-1,7,10,8};
		mergeSort(a);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " "); // should be 1 2 57 8 10
	}
}
