package algorithm_bfs_dfs;

import java.util.*;

// 比较笨的一个方法，想到每次iterate岛后，就存下坐标，写一个islands类，
// Java HashMap/HashSet用的1. hashCode， 2. equals 函数，两个都要override

// 做中：稍微看了一下答案，不需要专门 --- wrong
// https://leetcode.com/problems/number-of-distinct-islands/solution/
// 第一种解法很tricky，把坐标[x,y] 简单map到一个数，事实证明是有问题的，
//1 1 1 【1】 
//1 0 1 0
//0 0 0 0
//0 1 1 1
//【1】 1 0 1
// 标注的两个1，会被认为是同样的相对坐标，然而并不是！！！！一个是起始的第四个，一个是起始的左下角！！！

// 第二种解法好
// 如果两个island相同形状，那么【从左上角dfs得到的path】也应该相同 --- 注意 dfs要按照一定顺序
// 第一个island就是 0 | 0 -> -> -> 0 0 0 0

// O(R*C)

public class LeetCode694_medium_NumberOfDistinctIslands {
	
	// 0: starting point /exit a node;
	// 1,2,3,4: enter from a direction
	private void explore(int r, int c, int di, ArrayList<Integer> shape, int[][] grid) {
		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) {
			return;
		}
		
		grid[r][c] = 0;
		
		shape.add(di); // enter the node
		
		explore(r+1, c, 1, shape, grid);
		explore(r-1, c, 2, shape, grid);
		explore(r, c+1, 3, shape, grid);
		explore(r, c-1, 4, shape, grid);
		
		shape.add(0); // exit the node
	}
	
	
	public int numDistinctIslands(int[][] grid) {
		HashSet<ArrayList<Integer>> shapes = new HashSet<>();
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				ArrayList<Integer> shape = new ArrayList<>();
				explore(r, c ,0, shape, grid);
				if (shape.size() != 0) {
					shapes.add(shape);
				}
			}
		}
		
		return shapes.size();
	}
	
	
//	int[] dx = new int[] {1, -1, 0, 0};
//	int[] dy = new int[] {0, 0 ,1, -1};
//	
//    public int numDistinctIslands(int[][] grid) {
//        HashSet<HashSet<Integer>> islands = new HashSet<>();
//        
//        for (int r = 0; r < grid.length; r++) {
//        		for (int c = 0; c < grid[0].length; c++) {
//        			if (grid[r][c] == 1) {
//        				HashSet<Integer> island = new HashSet<Integer>();
//        				dfs(grid, r, c, island , r, c);
//        				if (island.size() != 0) {
//        					islands.add(island);
//        				}
//        				
//        			}
//        		}
//        }
//        
//        return islands.size();
//        
//    }
//    
//    public void dfs(int[][] grid, int r, int c, HashSet<Integer> island, int r0, int c0) {
//    		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) {
//    			return;
//    		}
//    		
//    		grid[r][c] = 0;
//    		island.add((r-r0)*grid[0].length + (c-c0));
//    		for (int k = 0; k < dx.length; k++) {
//    			dfs(grid, r+dx[k], c+dy[k], island, r0, c0);
//    		}
//    }
	
	static class Name implements Comparable<Name> {
		String name;
		Name(String name) {
			this.name = name;
		}
		
		@Override
		public int compareTo(Name that) {
			// TODO Auto-generated method stub
			return this.name.compareTo(that.name);
		}
		
		// equals我一开始写错了！写成了equals(Name that), 应该是obj
		@Override
		public boolean equals(Object that) {
			if ( !(that instanceof Name))
				return false;
			if (this == that)
				return true;
			
			Name obj = (Name) that;
			return this.name.equals(obj.name);
		}
		
		@Override
		public int hashCode() {
			return this.name.hashCode();
		}
	}
	
    
    public static void main(String[] args) {
    		String name1 = "abc";
    		String name2 = "abc";
    		System.out.println(name1 == name2); // should be false;
    		System.out.println(name1.equals(name2)); // should be true;
    		
    		Name n1 = new LeetCode694_medium_NumberOfDistinctIslands.Name(name1);
    		Name n2 = new LeetCode694_medium_NumberOfDistinctIslands.Name(name2);
    		
    		System.out.println(n1.compareTo(n2));
    		System.out.println(n1.equals(n2)); // should be true, why false?
    		
    		System.out.println(n1.hashCode());
    		System.out.println(n2.hashCode());
    		
    		HashMap<LeetCode694_medium_NumberOfDistinctIslands.Name, Integer> map = new HashMap<>();
    		map.put(n1, 111);
    		map.put(n2, 222);
    		System.out.println(map.size()); // 1 if 
    		
    		HashSet<Name> names = new HashSet<>();
    		names.add(n1);
    		names.add(n2);
    		System.out.println(names.size());
    		
    		System.out.println(map.get(new Name("abc")));
    		
    		HashSet<HashSet<Integer>> set = new HashSet<>();
    		HashSet<Integer> set1 = new HashSet<>(); set1.add(1);set1.add(2);
    		HashSet<Integer> set2 = new HashSet<>(); set2.add(2); set2.add(1);
    		set.add(set1);
    		set.add(set2);
    		
    		System.out.println("num of sets :" + set.size());
    }
    
}
