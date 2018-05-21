package algorithm_ladder_IV;

// 这题跟105还有几个数组变binary tree的题很像，分好区间就好了。
public class LeetCode106_ConstrBTfrInorderPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    		if (inorder == null || postorder == null) 
    			return null;
    		
    		if (inorder.length != postorder.length) {
    			// error message
    			throw new IllegalArgumentException("Inorder and Postorder array should have same length");
    		}
    		
        return builder(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    private TreeNode builder(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
    		// base case
    		if (!inArray(inorder, inStart, inEnd) || !inArray(postorder, postStart, postEnd)) {
    			return null;
    		}
    		
    		TreeNode root = new TreeNode(postorder[postEnd]);
    		int idx = findIdx(inorder, inStart, inEnd, postorder[postEnd]); // should be able to find
    		int leftLen = idx - inStart;
//    		int rightLen = inEnd - idx;
    		
    		TreeNode left = builder(inorder, inStart, idx-1, postorder, postStart, postStart+leftLen-1);
    		TreeNode right = builder(inorder, idx+1, inEnd, postorder, postStart + leftLen, postEnd-1);
    			
    		root.left = left;
    		root.right = right;
    		
    		return root;
    }
    
    private int findIdx(int[] arr, int start, int end, int target) {
    		for (int i = start; i <= end; i++) {
    			if (arr[i] == target) {
    				return i;
    			}
    		}
    		return -1; // if not found
    }
    
    private boolean inArray(int[] array, int i, int j) {
    		if (i < 0 || j < 0 || i >= array.length || j >= array.length || i > j) {
    			return false;
    		}
    		return true;
    }
}
