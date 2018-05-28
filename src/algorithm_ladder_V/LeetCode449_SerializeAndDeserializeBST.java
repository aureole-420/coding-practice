package algorithm_ladder_V;

// leetcode 449
// 不需要“#”来表示null，好处是BST可以通过直接寻在比first element打的元素来划分区间。
// encode： preorder traversal
// decode： divide and conquer ...
public class LeetCode449_SerializeAndDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
        		return "";
        }
        
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    private void serializeHelper(TreeNode root, StringBuilder sb) {
    		if (root == null) {
    			return;
    		}
    		
    		if (sb.length() != 0) {
    			sb.append(",");
    		} 
    		sb.append(Integer.toString(root.val));
    		
    		serializeHelper(root.left, sb);
    		serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
        		return null; // special case: data == "";
        }
        
        String[] tokens = data.split(",");
        int[] nums = new int[tokens.length];
        for (int i = 0; i < nums.length; i++) {
        		nums[i] = Integer.parseInt(tokens[i]);
        }
        return deserializeHelper(nums, 0, nums.length-1);
    }
    
    private TreeNode deserializeHelper(int[] nums, int start, int end) {
    		if (!inArray(nums, start, end)) {
    			return null;
    		}
    		
    		int pivot = nums[start];
    		int idx;
    		for (idx = start + 1; idx < end; idx++) {
    			if (nums[idx] > pivot) { // suppose not duplicate
    				break;
    			} 
    		}
    		
    		TreeNode root = new TreeNode(pivot);
    		System.out.println(idx);
    		root.left = deserializeHelper(nums, start+1, idx-1);
    		root.right = deserializeHelper(nums, idx+1, end);
    		
    		return root;
    }
    
    private boolean inArray(int[] nums, int start, int end) {
    		if (start < 0 || end >= nums.length ||start > end) {
    			return false;
    		}
    		
    		return true;
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
//		root.right = new TreeNode(4); root.right.left = new TreeNode(3);
		LeetCode449_SerializeAndDeserializeBST codec = new LeetCode449_SerializeAndDeserializeBST();
		System.out.println(codec.serialize(root)); // should be 2,1,4,3
		
		TreeNode rootRecon = codec.deserialize(codec.serialize(root));
		codec.deserialize("");
//		System.out.println("" + codec.serialize(null)); // should be 2,1,4,3
}
}
