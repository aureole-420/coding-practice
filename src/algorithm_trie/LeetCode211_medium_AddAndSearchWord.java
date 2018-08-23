package algorithm_trie;

// backtracking 能作出来但超时了。
public class LeetCode211_medium_AddAndSearchWord {

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
    /** Initialize your data structure here. */
    public void WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {

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

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return backtrack(word, 0, root);
    }

    private boolean backtrack(String word, int index, TrieNode node) {
        int len = word.length();
        for (int i = index; i < len; i++) {
            char currentChar = word.charAt(i);
            System.out.println(i + " " + currentChar);
            if (currentChar == '.') { // if currentChar is ., check every children
                for (char j = 'a'; j <= 'z'; j++) {
                    if (node.get(j) != null && backtrack(word, i+1, node.get(j))) {
                        return true;
                    }
                }
                System.out.println("1" + currentChar + " index:"+index + " word:"+word);
                return false;
            } else {
                if (node.get(currentChar) == null) {
                    return false; // currentChar not found
                }
                node = node.get(currentChar); // currentChar found.
            }
        }

        return node.isEndOfKey();
    }

    public static void main(String[] args) {
        LeetCode211_medium_AddAndSearchWord aas = new LeetCode211_medium_AddAndSearchWord();
        aas.WordDictionary();
        aas.addWord("bad");
        aas.addWord("mad");
        aas.addWord("dad");
        aas.search("b..");
    }
}
