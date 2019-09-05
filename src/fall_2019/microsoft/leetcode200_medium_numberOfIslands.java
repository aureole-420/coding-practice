package fall_2019.microsoft;

public class leetcode200_medium_numberOfIslands {

//    private int[] dx = new int[]{1, -1, 0, 0};
//    private int[] dy = new int[]{0, 0, 1, -1};
//    public int numIslands(char[][] grid) {
//        int count = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == '1') {
//                    count++;
//                    dfs(grid, i, j);
//                }
//            }
//        }
//        return count;
//    }
//
//    private void dfs(char[][] grid, int i, int j) {
//        grid[i][j] = '0';
//        for (int k = 0; k < dx.length; k++) {
//            int x = i + dx[k];
//            int y = j + dy[k];
//            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
//                continue;
//            }
//            dfs(grid, x, y);
//        }
//    }

    // union-find solution.

}
