package algorithm_trie;
import java.util.*;

// Use HashMap for first pass
// second pass build a heap.  no need to delete.
public class LeetCode692_medium_TopKFrequenceWords {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // java pq default minPQ
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>((a, b) -> {
            int diff = b.getValue() - a.getValue();
            if (diff != 0){
                return diff;
            }
            // diff == 0, have to compare alphabet
            return a.getKey().compareTo(b.getKey());
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            heap.add(entry);
        }

        List<String> list = new ArrayList<>(k);
        for (int i = k; i > 0; i--) {
            list.add(heap.poll().getKey());
        }

        return list;
    }
}
