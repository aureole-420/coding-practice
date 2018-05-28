package algorithm_ladder_V;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode297_SerializeDeserializeBT {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
        		return "";
        } else {
        		StringBuilder sb = new StringBuilder();
        		serializeBT(root, sb);
        		return sb.toString();
        }
    }
    
    // use a "#" to represent null;
    private void serializeBT(TreeNode root, StringBuilder sb) {
    		
    		// first character
    		if (sb.length() != 0) {
    			sb.append(",");
  
    		} 
    		
		if (root == null) {
			sb.append("#");
			return;
		} else {
			sb.append(Integer.toString(root.val));
		}
		System.out.println("root.left " + root.left);
    		serializeBT(root.left, sb);
    		serializeBT(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    		if (data == null || data.equals("")) {
    			return null;
    		}
    		
        String[] tokens = data.split(",");
        System.out.println("token length: " + tokens.length);
        
//        if ()
        Queue<String> queue = new LinkedList<String>();
        for (String token : tokens) {
        		queue.offer(token);
        }
        
        return buildBT(queue);
    }
    
    private TreeNode buildBT(Queue<String> queue) {
    		if (queue.isEmpty()) {
    			return null;
    		}
    		
    		String s = queue.poll();
    		if (s.equals("#")) {
    			return null;
    		} else {
    			TreeNode root = new TreeNode(Integer.parseInt(s));
    			root.left = buildBT(queue);
    			root.right = buildBT(queue);
    			return root;
    		}
    }
    
    
    public static void main(String[] args) {
    		TreeNode root = new TreeNode(1);
    		root.left = new TreeNode(2);
    		root.right = new TreeNode(3);
    		
    		LeetCode297_SerializeDeserializeBT sdbt = new LeetCode297_SerializeDeserializeBT();
    		System.out.println((sdbt.serialize(root)));
//    		System.out.println(sdbt.deserialize(sdbt.serialize(root)));
    }
}
