package algorithm_bfs_dfs;
import java.util.*;

public class practice_basic_backtracking {

    public List<Integer> getProd(int[] arr, int N) {
        List<Integer> result = new ArrayList<>();
        List<Integer> list = new LinkedList<>();

        dfs(arr, N, list, result, 0);
        return result;
    }

    private void dfs(int[] arr, int N, List<Integer> list, List<Integer> result, int pos) {
        if (list.size() == N) {
            int prod = 1;
            for (int i : list) {
                prod *= i;
            }

            result.add(prod);
            return;
        }

        if (pos >= arr.length) {
            return;
        }

        for (int i = pos; i < arr.length; i++) {
            list.add(arr[i]);
            dfs(arr, N, list, result, i+1);
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[] {3,2,1,4};
        practice_basic_backtracking bb = new practice_basic_backtracking();
        List<Integer> result = bb.getProd(arr, 3);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
