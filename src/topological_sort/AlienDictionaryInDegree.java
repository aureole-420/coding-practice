package topological_sort;

//import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 
 * 关键是用一个queue把每次indegree为0的全部放进去。
 *
 */
 
/**
一共需要两步：一，转化为graph。二：对graph使用拓补排序。


Map<Character, Integer> indegree用来保存已有的点的入度。

Map<Character, Set<Character>> map用来保存key输出之后会收到影响的点。

先遍历words中的所有字符c, indegree.put(c, 0)。这是因为有可能有一些点没有入度但是也出现了。 - 注意事项1


接下来遍历words数组，每次取出俩单词。然后判定俩单词的最小长度len，并遍历0~len-1对比char。(char cur, char next)

如果相等，什么都不做；如果不相等，那么就对map和indegree做相应计数。注意的地方是如果map中cur为key取出的set中已经有next，那说明我们已经算过这条边，此时indegree不计数。 - 注意事项2


之后就是拓扑排序。先遍历一遍indegree取出value为0的key，入队。每次队首取一个元素，然后map中取出其set，这些就是将会受到影响的点。在indegree中计数-1，如果为0入队即可。


最后如果结果的长度和indegree.size()不相等（我们把所有的char都放在了indegree即使入度为0），说明有环，返回空字符。

*/
public class AlienDictionaryInDegree {
	
	public String alienOrder(String[] words) {
		HashMap<Character, List<Character>> graph = new HashMap<>();
		HashMap<Character, Integer> indegree = new HashMap<>();
		for (String word : words) {
			for (char c : word.toCharArray()) {
				graph.put(c, new ArrayList<Character>());
				indegree.put(c, 0);
			}
		}
		
		for (int i = 0; i < words.length-1; i++) {
			char[] smallerWord = words[i].toCharArray();
			char[] greaterWord = words[i+1].toCharArray();
			for (int j = 0; j < smallerWord.length && j < greaterWord.length; j++) {
				char s = smallerWord[j], g = greaterWord[j];
				if (s == g) {continue;}
				if (!graph.get(s).contains(g)) {
					System.out.println(s + "->" + g);
					graph.get(s).add(g);
					indegree.put(g, indegree.get(g) + 1);
					
				}
				break;	
			}
		}
		
		StringBuilder sb = new StringBuilder();
		Queue<Character> queue = new LinkedList<Character>();
		for (char c : indegree.keySet()) {
			if (indegree.get(c) == 0) queue.offer(c);
		}
		
		while (!queue.isEmpty()) {
			char c = queue.poll();
			sb.append(c);
			for (char nb : graph.get(c)) {
				indegree.put(nb, indegree.get(nb) - 1);
				if (indegree.get(nb) == 0) queue.offer(nb);
			}
		}
		
		//System.out.println(sb.toString());
		//return sb.toString();
		return sb.length() == indegree.size() ? sb.toString() : "";	
	}
	
	
	
    public static void main(String[] args) {
		// String[] words = new String[] {"wrt", "wrf", "er", "ett", "rftt"};
		String[] words = new String[] {"wrt","wrf","er","ett","rftt","te"};
		// String[] words = new String[] {"za","zb","ca","cb"};
		AlienDictionaryInDegree ad = new AlienDictionaryInDegree();   
		System.out.println(ad.alienOrder(words));
		//assertEquals("wertf", ad.alienOrder(words));
}
}
