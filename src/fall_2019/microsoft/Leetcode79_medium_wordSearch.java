package fall_2019.microsoft;

public class Leetcode79_medium_wordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[] dx = new int[] {1, -1, 0, 0};
    int[] dy = new int[] {0, 0, 1, -1};
    private boolean dfs(char[][] board, int x, int y, String word, int pos) {
        if (pos == word.length()) // 注意这个base condition，不是放在sanity之后。
            return true;
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(pos)) {
            return false;
        }

        boolean wordFound = false;
        board[x][y] ^= 256;
        for (int k = 0; k < dx.length; k++) {
            wordFound = wordFound || dfs(board, x + dx[k], y + dy[k], word,pos+1);
        }
        board[x][y] ^= 256;
        return wordFound;
    }

    public static void main(String[] args) {
        System.out.println("" + (1 ^ 4));
        System.out.println("" + (5 ^ 256));
        System.out.println("" + (266 ^ 256));
        System.out.println("" + (10 ^ 256));
        System.out.println("" + (int)('a')); // 97
        System.out.println("" + (char) (97 ^ 256));
    }
}
