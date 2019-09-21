package fall_2019.palantir;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'findHighPoints' function below.
     *
     * The function is expected to return a 2D_BOOLEAN_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY elevations as parameter.
     */

    private static int[] dx = new int[]{1, -1, 0, 0, 1, 1, -1, -1};
    private static int[] dy = new int[]{0, 0, -1, 1, -1, 1, 1, -1};
    public static boolean[][] findHighPoints(int[][] elevations) {
        // corner case
        int m = elevations.length;
        int n = elevations[0].length;

        boolean[][] visited = new boolean[m][n];
        boolean[][] revisited = new boolean[m][n];
        boolean[][] result = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    boolean isHigh = isHighPoints(elevations, i, j, visited);
                    fillResult(elevations, i, j, revisited, result, isHigh);
                }
            }
        }
        return result;
    }

    // visited
    private static boolean isHighPoints(int[][] elevations, int i, int j, boolean[][] visited) {
        int m = elevations.length;
        int n = elevations[0].length;
        visited[i][j] = true;
        boolean isHigh = true;
        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x < 0 || y < 0 || x >= m || y >= n) {
                continue;
            }
            if ( elevations[i][j] < elevations[x][y]) {
                isHigh = false;
            }
            if (visited[x][y]) {
                continue;
            }
            if (elevations[i][j] == elevations[x][y]) {
                isHigh = isHigh && isHighPoints(elevations, x, y, visited);
            }
        }
        return isHigh;
    }

    private static void fillResult(int[][] elevations, int i, int j, boolean[][] revisited,  boolean[][] result, boolean isHigh) {
        if (revisited[i][j]) return;
        int m = elevations.length;
        int n = elevations[0].length;
        revisited[i][j] = true;
        result[i][j] = isHigh;
        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x < 0 || y < 0 || x >= m || y >= n) {
                continue;
            }
            if (elevations[i][j] == elevations[x][y]) {
                fillResult(elevations, x, y, revisited, result, isHigh);
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2, 1, 3, 4}, {1, 5, 2, 2, 2}, {4, 5, 1, 9, 7
        }, {3, 5,  3,  7,  6}, {4,  3,  1,  7,  3}};
        boolean[][] result = Result.findHighPoints(mat);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++){
                int temp = result[i][j] ? 1: 0;
                System.out.print(temp + " ");
            }
            System.out.println("\n");
        }
    }
}
