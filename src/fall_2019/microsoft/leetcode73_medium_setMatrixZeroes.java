package fall_2019.microsoft;

public class leetcode73_medium_setMatrixZeroes {

    //
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int rows = matrix.length, cols = matrix[0].length;
        boolean isZeroRow = false, isZeroCol = false;
        // first row and first col
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0)
                isZeroCol = true;
        }

        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0)
                isZeroRow = true;
        }

        // process now zeros
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < cols; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // process first col and first row
        if (isZeroCol) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
        if (isZeroRow) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
