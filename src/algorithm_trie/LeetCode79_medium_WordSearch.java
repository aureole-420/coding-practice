package algorithm_trie;

// 可以用trie，但这里因为只有一个word，直接用dfs比较简单
public class LeetCode79_medium_WordSearch {

    public boolean exist(char[][] board, String word) {
        int N = board.length;
        int M = board[0].length;
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (word.charAt(0) == board[i][j] && dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) { // index 越界，说明index=0，。。。。word.length-1全部都满足了
            return true;
        }

        // i，j 越界 / 走了回头路
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        // current char satisfies, dfs neighbours
        visited[i][j] = true;
        if (dfs(board, word, i+1, j, index+1, visited) ||
        dfs(board, word, i-1, j, index+1, visited) ||
        dfs(board, word, i, j-1, index+1, visited) ||
        dfs(board, word, i, j+1, index+1, visited)) {
            return true; // word found! no need to reset visited matrix.
        }

        visited[i][j] = false;
        return false;

    }
}
