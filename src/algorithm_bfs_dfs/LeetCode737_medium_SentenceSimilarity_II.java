package algorithm_bfs_dfs;
import java.util.*;

// 思路： 根据pairs构建一个undirected graph
// 根据每个词汇判断。。。

// 做后感想： corner case贼多
// corner case 1: words1 words2 中有词不在pair里面
// corner case 2: words1 words2 对应词完全相同，但不在pair里面
public class LeetCode737_medium_SentenceSimilarity_II {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1 == null || words2 == null || words1.length != words2.length) {
        		return false;
        }
        
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for (String[] pair: pairs) {
        		String w1 = pair[0];
        		String w2 = pair[1];
        		
        		map.putIfAbsent(w1, new HashSet<String>());
        		map.get(w1).add(w2);
        		map.putIfAbsent(w2, new HashSet<String>());
        		map.get(w2).add(w1);
        }
        
        for (int i = 0; i < words1.length; i++) {
        		String w1 = words1[i];
        		String w2 = words2[i];
        		
        		if (!isSimilar(w1, w2, new HashSet<String>(), map)) {
        			return false;
        		}
        }
        return true;
        
    }
    
    // starting from w1, dfs 
    private boolean isSimilar(String startingWord, String target, HashSet<String> visited,  HashMap<String, HashSet<String>> map) {
		// base case：两个词完全相同！！！但词不在map里面！
		if (startingWord.equals(target)) {
			return true;
		}
		
    		// corner case: 两个词相同
    		if (!map.containsKey(startingWord) || !map.containsKey(target)) {
    			return false;
    		}
    		

    		
    		if (visited.contains(startingWord)) {
    			return false;
    		}
    		
    		visited.add(startingWord);
    		
    		for (String neighbor : map.get(startingWord)) {
    			if (isSimilar(neighbor, target, visited, map)) {
    				return true;
    			}
    		}
    		
    		return false;
    }
    
}
