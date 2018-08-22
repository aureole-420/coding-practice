package algorithm_trie;

public class LeetCode208_ImplementTrie {

    private class TrieNode {
        private final int R = 26;
        private TrieNode[] link;
        private boolean endOfKey;

        public TrieNode() {
            link = new TrieNode[R];
        }

        public boolean isEndOfKey() {
            return endOfKey;
        }

        public void setEndOfKey() {
            endOfKey = true;
        }

        public boolean containsKey(char c) {
            return link[c-'a'] != null;
        }

        public TrieNode get(char c) {
            return link[c-'a'];
        }

        public void put(char c, TrieNode node) {
            link[c-'a'] = node;
        }
    }

    private TrieNode root;
    private int R;

    /** Initialize your data structure here. */
    public void Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }

        node.setEndOfKey();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchString(word);
        return node != null && node.isEndOfKey();
    }

    private TrieNode searchString(String word) {

        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                return null;
            }
            node = node.get(currentChar);
        }

        return node;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchString(prefix);

        return node != null;
    }
}

