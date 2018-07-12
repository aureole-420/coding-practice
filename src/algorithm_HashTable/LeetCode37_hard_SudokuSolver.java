package algorithm_HashTable;
import java.util.*;

// 做前： 我是这么想的，每个位置由于constraint，只能取某些值（use set to store），每次找到size为1的set，然后把该值填上
// 但下面这个test case 完全做不了
//..9748...
//7........
//.2.1.9...
//..7...24.
//.64.1.59.
//.98...3..
//...8.3.2.
//........6
//...2759..

// 最多到这种程度
//..9748...
//7..6.2...
//.2.1.9...
//..7986241
//264317598
//198524367
//...863.2.
//...491..6
//...2759..


// 做中： 看了答案：用的back tracking：
public class LeetCode37_hard_SudokuSolver {
	
    public void solveSudoku(char[][] board) {
    	
        Set<Character>[][] potentialIntegers = (Set<Character>[][]) new Set[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
        		for (int j = 0; j < board[0].length; j++) {
        			if (board[i][j] == '.') {
        				potentialIntegers[i][j] = new HashSet<Character>();
        				for (int num = 1; num <=9; num++) {
        					potentialIntegers[i][j].add((char) ('0'+ num));
        				}
        			}
        		}
        }        
        
        // set existing 
        for (int i = 0; i < board.length; i++) {
    			for (int j = 0; j < board[0].length; j++) {
    				if (board[i][j] != '.') {
    					setNumber(board, potentialIntegers, board[i][j], i, j);
    				}
    			}
        }
        
        for (int i = 0; i < board.length; i++) {
     			for (int j = 0; j < board[0].length; j++) {
     				if (board[i][j] == '.') {
     					System.out.print(potentialIntegers[i][j].size());
     				} else {
     					System.out.print(0);
     				}
     			}
     			System.out.print("\n");
         }
        
        while (true) {
        		int[] coords = next(potentialIntegers);
        		if (coords == null) {
        			break;
        		}
        		int i = coords[0], j = coords[1];
        		setNumber(board, potentialIntegers, potentialIntegers[i][j].iterator().next(), i, j);
        }
        
        
        for (int i = 0; i < board.length; i++) {
     			for (int j = 0; j < board[0].length; j++) {
     				System.out.print(board[i][j]);
     			}
     			System.out.print("\n");
         }
    }
    
    // if at i, and j 
    private void setNumber(char[][] board, Set<Character>[][] potentialIntegers, char num ,int i, int j) {
    		potentialIntegers[i][j] = null;
    		board[i][j] = num;
    		
    		// clear cols
    		for (int ii = 0; ii < 9; ii++) {
    			if (potentialIntegers[ii][j] != null) {
    				potentialIntegers[ii][j].remove(num);
    			} 			
    		}
    		
    		// clear rows
    		for (int jj = 0; jj < 9; jj++) {
    			if (potentialIntegers[i][jj] != null) {
    				potentialIntegers[i][jj].remove(num);
    			}
    		}
    		
    		// clear cube:
    		int cubeRow = i/3, cubeCol = j/3;
    		for (int ii = cubeRow*3; ii < cubeRow*3 + 3; ii++) {
    			for (int jj = cubeCol*3; jj < cubeCol*3 + 3; jj++) {
        			if (potentialIntegers[ii][jj] != null) {
        				potentialIntegers[ii][jj].remove(num);
        			}
    			}
    		}
    }
    
    private int[] next(Set<Character>[][] potentialIntegers) {
    		for (int i = 0; i < potentialIntegers.length; i++) {
    			for (int j = 0; j < potentialIntegers[0].length; j++) {
    				if (potentialIntegers[i][j] != null && potentialIntegers[i][j].size() == 1) {
    					return new int[] {i, j};
    				}
    			}
    		}
    		
    		return null;
    }
    
    public static void main (String[] args) {
    		HashMap<String, List<Integer>> map = new HashMap<>();
    		map.put("a", new LinkedList<>()); map.get("a").add(1); map.get("a").add(2);
    		map.put("b", new LinkedList<>()); map.get("b").add(1); map.get("b").add(2); map.get("b").add(1); map.get("b").add(2);
    		map.put("c", new LinkedList<>()); map.get("c").add(1); 
    		map.put("d", new LinkedList<>()); map.get("d").add(1); map.get("d").add(2);map.get("d").add(3);
    		
    		PriorityQueue<Map.Entry<String, List<Integer>>> pq = new PriorityQueue<>((a, b) -> a.getValue().size() - b.getValue().size());
    		
    		for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
    			pq.offer(entry);
    		}
    		
    		System.out.println(pq.peek().getKey()); // c 
    		map.get("c").add(3); map.get("c").add(4);
    		System.out.println(pq.peek().getKey()); // 还是c，说明pq自己不会更新，还是得手动更新
    		// entry map 不能再外部编辑！！！！并不能后续修改！！！
    		
    		TreeMap<String, List<Integer>> treemap = new TreeMap<>();
    		
    		
    }
}
