package fall_2019.jiuzhang_algorithm.chap8_stack_queue_hash_heap;

public class Lint130_heapify {

    public void heapify(int[] A) {
        // write your code here
        for (int i = A.length/2 -1; i >= 0; i--) {
            heapify(A, i);
        }
    }

    private void heapify(int[] A, int idx) {
        int len = A.length;
        int leftIdx = 2 * idx + 1;
        int rightIdx = 2 * idx + 2;

        int max = idx;
        if (leftIdx < len && A[leftIdx] < A[max]) {
            max = leftIdx;
        }
        if (rightIdx < len && A[rightIdx] < A[max]) {
            max = rightIdx;
        }

        if (max != idx) {
            swap(A, max, idx);

            heapify(A, max);
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
