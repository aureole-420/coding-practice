package algorithm_ladder_V;
import java.util.*;


public class VerifyPreorderSerializationOfBinaryTree {
	public boolean isValidSerialization(String preorder) {
        if (preorder.equals("")) return false; // corner case
        
        String[] tokens = preorder.split(",");
        LinkedList<String> queue = new LinkedList<String>();
        queue.addAll(Arrays.asList(tokens));
        
        return checkSerialization(queue) && queue.isEmpty();
    }
	
	private boolean checkSerialization(LinkedList<String> queue) {
		if (queue.isEmpty()) return false;
		
		String val = queue.poll();
		if (val.equals("#")) 
			return true;
		// else integer
		return checkSerialization(queue) && checkSerialization(queue); // check left and right;
	}
	
	public static void main(String[] args) {
		//TreeNode root = new TreeNode(1);
		VerifyPreorderSerializationOfBinaryTree v = new VerifyPreorderSerializationOfBinaryTree();
		System.out.println(v.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#")); // should be false;
	}
}
