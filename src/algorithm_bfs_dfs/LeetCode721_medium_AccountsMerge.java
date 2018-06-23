package algorithm_bfs_dfs;
import java.util.*;

// https://leetcode.com/problems/accounts-merge/description/
// 做前： email做节点, 数据结构比较复杂

// 一次过！但速度略慢。
// 构建完1.图 2.每个node（email）连结的accounts后
// dfs 每个component即可
public class LeetCode721_medium_AccountsMerge {
	
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
    		HashMap<String, HashSet<String>> graph = new HashMap<>(); // email to email
    		HashMap<String, HashSet<List<String>>> email2accounts = new HashMap<>();
    		
    		for (List<String> account : accounts) {
//    			String name = account.get(0);
    			// iterate every email
    			for (int i = 1; i < account.size(); i++) {
    				String email = account.get(i);
    				email2accounts.putIfAbsent(email, new HashSet<List<String>>());
    				email2accounts.get(email).add(account);
    				
    				graph.putIfAbsent(email, new HashSet<String>());
    				graph.get(email).addAll(account.subList(1, account.size()));
    			}
    		}
    		
    		
    		HashMap<String, Boolean> visited = new HashMap<>();
    		for (String email: graph.keySet()) {
    			visited.put(email, false);
    		}
    		
    		
    		List<List<String>> result = new LinkedList<>();
    		for (String email : graph.keySet()) {
    			if (!visited.get(email)) {
    				HashSet<List<String>> sameAccounts = new HashSet<>();
    				dfs(graph, email2accounts, visited, email, sameAccounts);
    				List<String> mergedAccount = mergeAccounts(sameAccounts);
    				result.add(mergedAccount);
    			}
    		}
    		
    		return result;
    }
    
    private void dfs(HashMap<String, HashSet<String>> graph, HashMap<String, HashSet<List<String>>> email2accounts, 
    		HashMap<String, Boolean> visited, String email, HashSet<List<String>> sameAccounts) {
    		if (visited.get(email)) {
    			return;
    		}
    		
    		visited.put(email, true);
    		sameAccounts.addAll(email2accounts.get(email));
    		
    		for (String neighbour : graph.get(email)) {
    			dfs(graph, email2accounts, visited, neighbour, sameAccounts);
    		}
    }
    
    private List<String> mergeAccounts(HashSet<List<String>> accounts) {
    		List<String> result = new ArrayList<String>();
    		if (accounts.size() == 0) return result;
    		
    		
    		boolean addName = false;
    		HashSet<String> emails = new HashSet<>();
    		for (List<String> account : accounts) {
    			if (!addName) { // add name first
    				addName = true;
    				String name = account.get(0);
    				result.add(name);
    			}
    			emails.addAll(account.subList(1, account.size()));
    		}
    		List<String> emailsList = new ArrayList<String>(emails);
    		Collections.sort(emailsList);
    		
    		result.addAll(emailsList); // add emails.
    		
    		
    		return result;
    }
    
    public static void main(String[] args) {
    		List<String> list = new ArrayList<>();
    		list.add("bb"); list.add("cc");list.add("aa"); 
    		Collections.sort(list); // -- sort is in place.
    		
    		System.out.println(list.subList(1, 1));
    		System.out.println(list.get(0));
    }
}
