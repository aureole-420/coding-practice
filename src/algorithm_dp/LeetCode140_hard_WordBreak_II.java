package algorithm_dp;
import java.util.*;


// 做前：其实我想到了dp的做法

// 做中：做一下记忆话搜索的做法
public class LeetCode140_hard_WordBreak_II {
	
	HashMap<Integer, List<String>> map = new HashMap<>();
	
	public List<String> wordBreak(String s, List<String> wordDict) {
		return dfs(s, wordDict, 0);
	}
	
	// returns all word break for chars from 0 to start (exclusive)
	private List<String> dfs(String s, List<String> wordDict, int start) {
		// 
		if (map.containsKey(start)) {
			return map.get(start);
		}
		
		List<String> res = new LinkedList<String>();
		if (start == s.length()) {
			res.add("");
		}
		
		for (int end = start+1; end <= s.length(); end++) {
			if (wordDict.contains(s.substring(start, end))) {
				List<String> sublist = dfs(s, wordDict, end);
				for (String sub : sublist) {
					res.add(s.substring(start, end) + (sub.equals("") ? "" : " ") + sub);
				}
			}
		}
		
		map.put(start, res);
		return res;
	}
}
