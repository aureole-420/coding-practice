package algorithm_trie;

// 做后：犯了两个错误：
// 1。 OO mistake： recusion with argument (Ans), but use NEW method in the process, thus no longer access the original object
// 2. minor one, 自己单独也算是？所以可以不用layer
public class LeetCode720_easy_LongestWordInDictionary {

    class ResultType {
        int maxLength;
        String word;
        int layer;

        ResultType(int len, String w, int l) {
            this.maxLength  = len;
            this.word = w;
            this.layer = l;
        }

        public void setMaxLength(int maxLength) {
            this.maxLength = maxLength;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public void setLayer(int layer) {
            this.layer = layer;
        }
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word = null;

    }

    private TrieNode buildTrie(String[] words) {

        TrieNode root = new TrieNode();

        for (String word: words) {
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

    public String longestWord(String[] words) {
        TrieNode root = buildTrie(words);

        ResultType ans = new ResultType(-1, "", -1);

        dfsTrie(root, root, ans, 0);

//        System.out.println("<longestWord> " +ans.maxLength + "  " + ans.layer  + " [ans.object.id]" + ans);
        return (ans.maxLength > 0 && ans.layer >= 2) ? ans.word : "";

    }

    private void dfsTrie(TrieNode node, TrieNode root, ResultType ans, int layer) {
        if (node != root && node.word == null) {
            return;
        }

        if (node.word != null) { // not root.
            int diff = node.word.length() - ans.maxLength;
//            System.out.println("diff: " + diff);
            if (diff > 0) { // chose longer one.
//                ans = new ResultType(node.word.length(), node.word, layer);
                ans.setMaxLength(node.word.length());
                ans.setWord(node.word);
                ans.setLayer(layer);
//                System.out.println("<dfsTrie.choice1>:" + ans.maxLength + "  " + ans.layer + " [ans.object.id]" + ans);
            } else if (diff == 0) { //same length, choose lexical smaller one.
//                ans = node.word.compareTo(ans.word) < 0 ? new ResultType(node.word.length(), node.word, layer) : ans;
                if (node.word.compareTo(ans.word) < 0) {
                    ans.setMaxLength(node.word.length());
                    ans.setWord(node.word);
                    ans.setLayer(layer);
                }
//                System.out.println("<dfsTrie.choice2>:" + ans.maxLength + "  " + ans.layer);
            }
        }

        for (TrieNode child : node.next) {
            if (child != null) {
//                System.out.println(node.word + "#" + child.word);
                dfsTrie(child, root, ans, layer+1);
            }
        }
    }

    public static void main(String[] args) {
        String[] words = new String[]{"w","wo","wor","worl","world"};
        LeetCode720_easy_LongestWordInDictionary lwd = new LeetCode720_easy_LongestWordInDictionary();
        System.out.println("ans is " + lwd.longestWord(words));

    }
}
