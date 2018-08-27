package algorithm_trie;

import java.util.*;


// 这题比较好的做法的关键是，在建立trie的时候就把score加入到每个prefix中去
// another point: 这题并没有说到底有哪些char，很有可能有unicode所以应该用hashmap构建trie而不是
// 因为有重复的string，每次更新节点，
// e.g insert（abc, 3), insert(abc, 5)
// 第二个操作相当于把 abc的prefix， a, ab, abc 全部都plus 2

// 应该问一个问题，prefix is ""是否算数，如果算数的话就需要把rootnode也处理一下
public class LeetCode677_medium_MapSumPairs {

    HashMap<String, Integer> map; // 处理同样的string （更新问题）
    TrieNode root;

    class TrieNode {
        HashMap<Character, TrieNode> next = new HashMap<>();
        // String word;// actually not really necessary.
        int score;
    }

    /** Initialize your data structure here. */
    public void MapSum() {
        map = new HashMap<>();
        root = new TrieNode();
    }

    public void insert(String key, int val) {

        TrieNode node = root;

        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);

        for (char c : key.toCharArray()) {

            // create child node if there is none
            if (node.next.get(c) == null) {
                node.next.put(c, new TrieNode());
            }

            // update score
            node.next.get(c).score += delta;
            node = node.next.get(c);
        }
    }

    // get score for prefix
    public int sum(String prefix) {

        TrieNode node = root;

        for (char c : prefix.toCharArray()) {
            if (node.next.get(c) == null) {
                return 0;
            }
            node = node.next.get(c);
        }

        return node.score;
    }


}
