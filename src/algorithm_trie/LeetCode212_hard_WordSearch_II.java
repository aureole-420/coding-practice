package algorithm_trie;
import java.util.*;

// 做后： trie可以在最后把word存，不用遍历时还要记载路径
// dfs时可以用一个#暂时占位，就不需要 visited矩阵了

public class LeetCode212_hard_WordSearch_II {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length;j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    // dfs every possible string from...
    private void dfs(char[][] board, int i, int j, TrieNode node,  List<String> res) {
        char c = board[i][j];
        if (c == '#' || node.next[c-'a'] == null) {
            return;
        }

        node = node.next[c-'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null; // de-dupe
        }

        // 可以maintain一个visited 矩阵，也可以直接用一个
        board[i][j] = '#';
        if (i > 0) dfs(board, i -1, j, node, res);
        if (j > 0) dfs(board, i, j-1, node, res);
        if (i < board.length-1) dfs(board, i+1, j ,node, res);
        if (j < board[0].length-1) dfs(board, i, j+1, node, res);
        board[i][j] = c;

    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.next[c-'a'] == null) {
                    node.next[c-'a'] = new TrieNode();
                }
                node = node.next[c-'a'];
            }

            node.word = word;
        }

        return root;
    }

    private class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
