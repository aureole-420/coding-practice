package fall_2019.dropbox;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OA_autoCompleteFeature {

    class TrieNode {
        String word;
        int score;
        int maxScoreOfChildrenNodes;
        Map<Character, TrieNode> children;
        TrieNode(){
            children = new HashMap<>();
            maxScoreOfChildrenNodes = Integer.MIN_VALUE;
        }
    }

    private void addWord(TrieNode root, String token, int score) {
        TrieNode cur = root;
        for (char c : token.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }

            if (cur.word != null) {
                cur.maxScoreOfChildrenNodes = Math.max(score, cur.maxScoreOfChildrenNodes);
            }
            cur = cur.children.get(c);
        }
        cur.word = token;
        cur.score = score;
    }

    private int getScore(TrieNode root, String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return 0;
            }

            cur = cur.children.get(c);
        }

        return cur.maxScoreOfChildrenNodes;
    }

    class Document {
        String title;
        String body;
        Document(String t, String b) {
            this.title = t;
            this.body = b;
        }
    }

    private TrieNode root;

    public OA_autoCompleteFeature(List<Document> docs) {
        HashMap<String, Integer> word2Score = new HashMap<>();
        for (Document doc : docs) {
            String[] wordsInTitle = doc.title.split("\\+");
            for (String word : wordsInTitle) {
                word2Score.put(word, word2Score.getOrDefault(word, 0) + 10);
            }
            String[] wordsInBody = doc.body.split("\\+");
            for (String word : wordsInBody) {
                word2Score.put(word, word2Score.getOrDefault(word, 0) + 1);
            }
        }

        this.root = new TrieNode();
        for (String word : word2Score.keySet()) {
            int score = word2Score.get(word);
            addWord(root, word, score);
        }
    }

    public int autoComplete(TrieNode root, String str) {
        return getScore(root, str);
    }
}
