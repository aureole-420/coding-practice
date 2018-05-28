package algorithm_ladder_V;

import java.util.LinkedList;
import java.util.Queue;

// 这题太经典了！
//特殊形式的分治
public class LeetCode331_VerifyPreorderSerializationOfBT {
    public boolean isValidSerialization(String preorder) {
    		if (preorder == null || preorder.length() == 0) {
    			return false;
    		}
    		
    		String[] tokens = preorder.split(",");
        Queue<String> queue = new LinkedList<>();
        
        for (String token : tokens) {
        		queue.offer(token);
        }
        
        checkBT(queue);
        
        return queue.isEmpty();
    }
    
    private boolean checkBT(Queue<String> queue) {
    		if (queue.isEmpty()) {
    			return false;
    		}
    		
    		String token = queue.peek();
    		if (token.equals("#")) { // string判断用string
    			queue.poll();
    			return true;
    		} else {
    			queue.poll();
    			return checkBT(queue) && checkBT(queue);
    		}
    }
}
