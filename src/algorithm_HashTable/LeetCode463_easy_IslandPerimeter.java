package algorithm_HashTable;

// 做前，我只想到dfs整个岛，需要time / space O(n*m),O(n*m)


// 这题巧在不需要任何 额外存储！！！

// 看了答案，其实不需要dfs，正常访问就可以了
// 每个岛+4， 与左/上 祥林的话就-2， 只算两条边，确保internal edge 只被count 一次
// https://leetcode.com/problems/island-perimeter/discuss/94992/Java-9-line-solution-add-4-for-each-land-and-remove-2-for-each-internal-edge
public class LeetCode463_easy_IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
        		return 0;
        }
        
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
        		for (int j = 0; j < grid[0].length; j++) {
        			if (grid[i][j] == 1) {
        				count += 4;
        				if (i > 0 && grid[i-1][j] == 1) {
        					count -= 2;
        				}
        				if (j > 0 && grid[i][j-1] == 1) {
        					count -= 2;
        				}
        			}
        		}
        }
        
        return count;
    }
}
