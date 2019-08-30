package fall_2019.jiuzhang_algorithm.chap8_stack_queue_hash_heap;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Lint460_hard_LFU {

    class LFUCache {

        private int capacity;
        private int minFreq;
        private Map<Integer, Integer> key2Val;
        private Map<Integer, Integer> key2Freq;
        private Map<Integer, LinkedHashSet<Integer>> freq2LRUKeys;


        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.minFreq = -1;
            this.key2Val = new HashMap<>();
            this.key2Freq = new HashMap<>();
            this.freq2LRUKeys = new HashMap<>();
        }

        public int get(int key) {
            if (!key2Val.containsKey(key)) {
                return -1;
            }

            int freq = key2Freq.get(key);


            freq2LRUKeys.get(freq).remove(key);
            if (freq == minFreq && freq2LRUKeys.get(freq).size() == 0) {
                minFreq++;
            }
            putFreq(key, freq + 1);

            return key2Val.get(key);
        }

        public void put(int key, int value) {
            if (capacity <= 0) return;

            if (key2Val.containsKey(key)) {
                get(key); // update freq
                key2Val.put(key, value); // update value
                return;
            }

            // evict for new key if necessary
            if (key2Val.size() == capacity) {
                int evictKey = freq2LRUKeys.get(minFreq).iterator().next();
                freq2LRUKeys.get(minFreq).remove(evictKey);
                key2Val.remove(evictKey);
                key2Freq.remove(evictKey);
            }

            key2Val.put(key,value);
            minFreq = 1;
            putFreq(key, 1);
        }

        private void putFreq(int key, int freq) {
            key2Freq.put(key, freq);
            freq2LRUKeys.computeIfAbsent(freq, ignore -> new LinkedHashSet<>());
            freq2LRUKeys.get(freq).add(key);
        }
    }
}
