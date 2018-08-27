package algorithm_trie;

import java.util.*;


// 看了答案后： 我想到了用suffix trie，但没想到另外的关系：
// a+b is palindrome,
// if a > b, a-rev(b) must also be palindrome
// if a < b, b-rev(a) must also be palindrome

// search a,
// 1. 如果b已经iterate 完了，只用检查 a-rev（b), 也就是a(j, end) is palindrome
// 2. 最后a iterate 完了，只用检查 b-rev（a), i.e., b(0, j) is panlindrome or not  ---- 这一部分可以在build trie时做了。
public class LeetCode336_hard_PalindromePairs {

    private class TrieNode {
        TrieNode[] next;
        int index; // the index word in the array
        List<Integer> list;

        TrieNode () {
            next = new TrieNode[26];
            index= -1;
            list = new ArrayList<>();
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            searchWord(root, words, i, res);
        }

        return res;
    }

    // build the suffix trie
    private void addWord(TrieNode root, String word, int index) {
        TrieNode node = root;
        // the index word in the array
        for (int j = word.length()-1; j >= 0; j--) {
            char c = word.charAt(j);
            if (node.next[c-'a'] == null) {
                node.next[c-'a'] = new TrieNode();
            }

            // e.g. bba, when j = 2, bba not palindrome
            // when j = 1, bb is palindrome,
            if (isPalindrome(word, 0, j)) {
                node.list.add(index);
            }

            node = node.next[c-'a'];
        }
        node.index = index;
        node.list.add(index); // corresponds to "", because isPalindrome is inclusive and cannot check "".
    }

    private void searchWord(TrieNode root, String[] words, int i, List<List<Integer>> res) {

        for (int j = 0; j < words[i].length(); j++) {

            // a valid word && not the same && rest of words[i] is palindrome
            if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length()-1)) {
                res.add(Arrays.asList(i, root.index));
            }

            root = root.next[words[i].charAt(j) - 'a'];
            if (root == null) return; // not satisfied
        }

        // words[i] is finished.

        for (int j : root.list) {
            if (j != i) {
                res.add(Arrays.asList(i, j));
            }
        }
    }

    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++; j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = new String[] {"ba", "a", "aaa"};
        LeetCode336_hard_PalindromePairs pp = new LeetCode336_hard_PalindromePairs();

        List<List<Integer>> res = pp.palindromePairs(words);


    }
}
