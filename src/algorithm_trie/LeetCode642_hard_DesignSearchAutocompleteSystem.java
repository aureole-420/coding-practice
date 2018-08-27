package algorithm_trie;
import java.util.*;

// 看了答案后：
// trie是动态更新的，每当一个sentence输入完（ended by "#"）， 这个sentence也要加入trie中
// 所以不要在build trie时就排序 （maintain一个pq成本太高），
// input char时把当前prefix TrieNode里所有的满足prefix的sentence都再拿来排序就可以了。

// 复杂度： constructor (n * k), 每个句子k个单词长。
// input (p + m log m) , p the length of prefix til now.
public class LeetCode642_hard_DesignSearchAutocompleteSystem {

    class TrieNode {
        Map<Character, TrieNode> next;
        Map<String, Integer> counts;
        boolean isWord;

        TrieNode() {
            counts = new HashMap<>();
            next = new HashMap<>();
            isWord = false;
        }
    }


    private TrieNode root;
    String prefix;

    // constructor
    public void AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";

        for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i];
            int repeatedTimes = times[i];
            add(sentence, repeatedTimes);
        }
    }

    public List<String> input(char c) {

        if (c == '#') { // end of sentence
            add(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }

        prefix = prefix + c;

        TrieNode node = root;
        for (char cc : prefix.toCharArray()) {
            if (node.next.get(cc) == null) {
                node.next.put(cc, new TrieNode());
            }
            node = node.next.get(cc);
        }

        List<String> res= new ArrayList<>();
        // max queue with smaller key in priority
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((s1, s2) -> s1.getValue()==s2.getValue()? s1.getKey().compareTo(s2.getKey()) :s2.getValue()-s1.getValue());

        for (Map.Entry<String, Integer> entry : node.counts.entrySet()) {
            pq.add(entry);
        }

        int k = 0;
        while (!pq.isEmpty() && k < 3) {
            res.add(pq.poll().getKey());
            k++;
        }

        return res;
    }

    // sentence repeated n times
    private void add(String sentence, int repeatedTimes) {
        TrieNode cur = root;
        for (char c : sentence.toCharArray()) {
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new TrieNode());
            }

            // update children's counts
            TrieNode child = cur.next.get(c);
            child.counts.put(sentence, child.counts.getOrDefault(sentence, 0) + repeatedTimes);
            cur = child;
        }

        cur.isWord = true;
    }


}
