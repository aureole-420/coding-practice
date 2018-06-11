package algorithm_bfs_dfs;

import java.util.List;

import java.util.*;

// 这题太傻逼了，简单的recursive，却因为list里面各种傻逼假设
// 难道这题考得是沟通？
public class LeetCode690_easy_EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        // corner case
    		HashMap<Integer, Employee> map = new HashMap<>();
    		for (Employee e : employees) {
    			map.put(e.id, e);
    		}
    		
    		return getImportance(map, id);
    }
    
    private int getImportance(HashMap<Integer, Employee> map, int id) {
    		Employee epl = map.get(id);
    		if (epl.subordinates.size() == 0) {
    			return epl.importance;
    		}
    		
    		int res = epl.importance;
    		for (int eId : epl.subordinates) {
    			res += getImportance(map, eId);
    		}
    		
    		return res;
    }
}
