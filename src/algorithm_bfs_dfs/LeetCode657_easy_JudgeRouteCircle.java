package algorithm_bfs_dfs;

// 简单的绕圈
public class LeetCode657_easy_JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
        		return false;
        }
        
        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); i++) {
        		char c = moves.charAt(i);
        		
        		if (c == 'L') {
        			x--;
        		} else if (c =='R') {
        			x++;
        		} else if (c == 'U') {
        			y++;
        		} else {
        			y--;
        		}
        }
        
        return x == 0 && y == 0;
    }
}
