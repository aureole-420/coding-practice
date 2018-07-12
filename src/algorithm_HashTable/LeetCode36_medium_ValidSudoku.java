package algorithm_HashTable;
import java.util.*;
// 做前，每一行每一列都是一个set，每一个3x3也是一个set？
// 总共9*2 + 9 = 27 sets？
// O(m*n) time and space complexity 

// 做中：看了这个答案，真是truly elegant
// 对每个点 (i,j),做一个encoding， 如果A[i,j1] == A[i,j2],会有同样的encoding，然后会重复
public class LeetCode36_medium_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        
        for (int i = 0; i < board.length; i++) {
        		for (int j = 0; j < board[0].length; j++) {
        			if (board[i][j] == '.') {
        				continue;
        			}
        			
        			String row = board[i][j] + " in row " + i;
        			String col = board[i][j] + " in col " + j;
        			String cube = board[i][j] + " cube (" + i/3 + "," + j/3 + ")";
        			
        			if (!seen.add(row) || !seen.add(col) || !seen.add(cube)) {
        				return false;
        			}
        		}
        }
        
        return true;
    }
}
