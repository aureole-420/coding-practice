package algorithm_graph_I;

import java.util.*;

/*
 * 等同于再一个无向图中做BFS，起点是beginWord，终点是endWord
 * 比较简单的想法是先根据wordlist构建无向图，再进行常规的bfs搜索。
 * 快一些的方法是不够造无向图，每一步直接搜索adjcent nodes
 */
public class WordLadder {
	
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    		Set<String> marked = new HashSet<>();
    		Queue<String> queue = new LinkedList<String>();
    		queue.offer(beginWord); 
    		marked.add(beginWord);
    		
    		int layer = 1;
    		int layerSize = 1;
    		while (!queue.isEmpty()) {
    			String cur = queue.poll(); 
    			if (cur.equals(endWord)) 
    				return layer;
    			layerSize--;
    			
    			//找cur的所有adjacent nodes
    			for (String s : wordList) {
    				if (isAdjacent(cur, s)) {
    					if (!marked.contains(s)) {
    						marked.add(s);
    						queue.offer(s);
    					}
    				}
    			}
    			
    			if (layerSize == 0) {
    				layerSize = queue.size();
    				layer++;
    			}
    		}
    		
    		// if not found;
        return 0;
    }
    
    private boolean isAdjacent(String a, String b) {
    		if (a == null || b == null || a.length() != b.length()) return false;
    		int diff = 0;
    		for (int i = 0; i < a.length(); i++) {
    			if (a.charAt(i) != b.charAt(i)) {
    				diff++;
    			}
    		}
    		return diff == 1 ? true : false;
    }
    
    public static void main(String[] args) {
    		
    	String bw = "hit", ew = "cog";
    	LinkedList<String> wl = new LinkedList<>();
    	wl.addLast("hot"); wl.addLast("dot");
    	wl.addLast("dog"); wl.addLast("lot");
    	wl.addLast("log");wl.addLast("cog");
    	WordLadder w = new WordLadder();
    	System.out.println(w.ladderLength(bw, ew, wl)); // should be 5
    }
}
