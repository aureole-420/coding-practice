package facebook;
import java.util.*;

// classic backtracking
public class LeetCode78_medium_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        dfs(nums, 0, list, res);

        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> list, List<List<Integer>> res) {

        res.add(new ArrayList<>(list));

        for (int idx = start; idx < nums.length; idx++) {
            list.add(nums[idx]);
            dfs(nums, idx+1, list, res); // when idx+1 == nums.length
            list.remove(list.size()-1);
        }
    }

}
