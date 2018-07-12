package algorithm_HashTable;
import java.util.*;

// 做前： hashmap，从头扫到尾，然后second pass
// 还有更简单的答案吗？

// --- 事实证明不需要two pass，用set就好了。
// 做中： 第一高票用了bit manipulation，还不会
// 第二高票用了两个set，实现了one pass，一旦重复就丢入答案。
public class LeetCode187_medium_RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>(), doubleSeen = new HashSet<>();
        
        for (int i = 0; i+9 < s.length(); i++) {
        		String ten = s.substring(i, i+10);
        		
        		if (!seen.add(ten)) {
        			doubleSeen.add(ten);
        		}
        }
        
        return new ArrayList<String>(doubleSeen);
    }
}
