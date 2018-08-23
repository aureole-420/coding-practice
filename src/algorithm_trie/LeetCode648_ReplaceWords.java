package algorithm_trie;


import java.util.*;

// 做后：讨论比较tricky，要画图
// 0. 沿着word 的每个char go through trie， 第一个prefix就是prefix， 如果没有找到prefix1那就返回原来的值。
// 1。1 如果某个char没有，一定是没找到prefix
// 1。2 某个char存在，那么久接招往下找
//      1。2。1 如果该node存在word，那就是找到prefix了
// 当word的chars已经遍历完了，还没找到prefix，那也是没有prefix！！！！
public class LeetCode648_ReplaceWords {

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word = null;
    }

    private TrieNode buildTrie(List<String> dict) {

        TrieNode root = new TrieNode();

        for (String word : dict) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    node.next[c-'a'] = new TrieNode();
                }
                node = node.next[c-'a'];
            }
            node.word = word;
        }

        return root;
    }

    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = buildTrie(dict);

        String[] words = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            TrieNode node = root;
            boolean done = false;

            // if found, replace with the word in that trie node
            // if not found,
            char[] wordArr = word.toCharArray();
            for (int i =0; i < wordArr.length; i++) {
                char c = wordArr[i];

                if (node.next[c-'a'] == null) { // not found
                    sb.append(word + " ");
                    done = true;
                    break;
                }

                node = node.next[c-'a'];
                if (node.word != null) { // found a root
                    sb.append(node.word + " ");
                    done = true;
                    break;
                }
            }
            if (!done) sb.append(word + " "); // special case:  "ra" in dist, but "r" -- still not found a root
        }

        return sb.toString().trim();
    }
}
