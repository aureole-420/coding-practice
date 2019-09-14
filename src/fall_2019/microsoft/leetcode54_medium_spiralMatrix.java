package fall_2019.microsoft;

import java.util.LinkedList;
import java.util.List;

public class leetcode54_medium_spiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};
        int x = 0, y = 0;
        int xlen = matrix.length, ylen = matrix[0].length;

        int count = ylen * xlen;
        int direction = 0; // initially right, then down, left, up, then right again.
        int numOfTurns = 0;
        xlen--;
        while (count > 0) {
            int curLen = numOfTurns % 2 == 0 ? ylen-- : xlen--;
            System.out.println("curLen = " + curLen + " curDir=" + direction + " curCount=" + count);
            for (int j = 0; j < curLen; j++) {
                System.out.println("j = " + j + " x="+x + " y="+y);
                System.out.println("j = " + j + " mat = " + matrix[x][y]);
                result.add(matrix[x][y]);
                x += dx[direction];
                y += dy[direction];
                count--;
            }

            System.out.println("x="+x + " y="+y);
            x -= dx[direction];
            y -= dy[direction];
            System.out.println("x="+x + " y="+y);
            numOfTurns++;
            direction = (direction + 1) % 4;
            x += dx[direction];
            y += dy[direction];
            System.out.println("x="+x + " y="+y);
        }

        return result;
    }

    public static void main(String[] args) {
        leetcode54_medium_spiralMatrix sm = new leetcode54_medium_spiralMatrix();
        int[][] mat = new int[][] {{1,2,3}, {4,5,6}, {7, 8, 9}};
//        int[][] mat = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(sm.spiralOrder(mat));
    }
}
