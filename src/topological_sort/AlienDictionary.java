package topological_sort;

//import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// LeetCode 269
/**
 * 速度慢的原因可能是用了太多hashmap？
 *
 */
public class AlienDictionary {
	
	HashMap<Character, Boolean> marked = new HashMap<Character, Boolean>();
	HashMap<Character, Boolean> inCallStack = new HashMap<Character, Boolean>();
	HashMap<Character, HashSet<Character>> charGraph = new HashMap<Character, HashSet<Character>>();
	Deque<Character> resultStack = new ArrayDeque<Character>();
    public String alienOrder(String[] words) {
    	
    		// 1.define basic graph structure;
    		defineGraph(words);
    		
    		// 2. compare adjacent strings for Graph's edges.
    		for (int i = 0; i < words.length-1; i++) {
    			addEdge(words[i], words[i+1]);
    		}
    		System.out.println(charGraph.size());
    		
    		// 3. topological sort the edge.
    		for (char c : charGraph.keySet()) {
    			if (!marked.get(c)) {
    				if (dfs(c) == false) { // there is cycle in it!
    					return "";
    				};
    			}
    		}
        
    		// 4. no cycle
    		StringBuilder sb = new StringBuilder();
    		while (!resultStack.isEmpty()) {
    			sb.append(resultStack.pop());
    		}
    		System.out.println(sb.toString());
    		return sb.toString();
    }
    
    private void defineGraph(String[] words) {
    		HashSet<Character> set = new HashSet<Character>();
    		for (String word : words) {
    			for (char c : word.toCharArray()) {
    				set.add(c);
    			}
    		}
    		for (char c : set) {
			marked.put(c, false);
			inCallStack.put(c, false);
			charGraph.put(c, new HashSet<Character>());
    		}
    }
    
    private boolean dfs(char c) { // true: no cycle; false: cycle
    		marked.put(c, true);
    		inCallStack.put(c, true);
    			System.out.println(c);
    			for (char n : charGraph.get(c)) {
    				if (inCallStack.get(n)) { // in call stack.
    					return false;
    				} else if (!marked.get(n)) { // available neighbour
    					if (dfs(n) == false) return false;
    				} // else continue;
    			}
    		inCallStack.put(c, false);
    
    		resultStack.push(c);
    		
    		return true;
    }
    
    private void addEdge(String smallerWord, String greaterWord) {
    		char[] sW = smallerWord.toCharArray();
    		char[] gW = greaterWord.toCharArray();
    		for (int i = 0; i < sW.length & i <gW.length; i++) {
    			if (sW[i] == gW[i]) {
    				continue;
    			} else { // then it must be sW[i] < gW[i], add an edge: sW[i] -> gW[i]
    				charGraph.get(sW[i]).add(gW[i]);
    				return;
    			}
    		}
    }
    
    public static void main(String[] args) {
    		String[] words = new String[] {"wrt", "wrf", "er", "ett", "rftt"};
    		AlienDictionary ad = new AlienDictionary();                       
//    		assertEquals("wertf", ad.alienOrder(words));
    }
}
