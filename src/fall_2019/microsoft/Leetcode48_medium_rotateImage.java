package fall_2019.microsoft;

public class Leetcode48_medium_rotateImage {

    public void rotate(int[][] matrix) {
        if (matrix == null) return;
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) { // 只用iterate 半边square
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            int j = 0, k = N-1;
            while (j < k) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++; k--;
            }
        }
    }
}
