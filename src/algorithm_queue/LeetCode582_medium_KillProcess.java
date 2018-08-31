package algorithm_queue;

import java.util.*;
// 其实挺简单的。
// 想法简单就直接构造tree
// implementation简单的话就用hashmap
public class LeetCode582_medium_KillProcess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < pid.size(); i++) {
            if (ppid.get(i)  > 0) {
                List<Integer> children = map.getOrDefault(ppid.get(i), new ArrayList<Integer>());
                children.add(pid.get(i));
                map.put(ppid.get(i), children);
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(kill);
        dfs(map, kill, result);
        return result;
    }


    private void dfs(HashMap<Integer, List<Integer>> map, int kill, List<Integer> result) {
        if (map.containsKey(kill)) {
            for (int p : map.get(kill)) {
                result.add(p);
                dfs(map, p, result);
            }
        }

    }

}
