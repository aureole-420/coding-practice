package algorithm_ladder_IV;

public class LeetCode105_ContrBTfrPreorderInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return builder(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    private TreeNode builder(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
    		if (!inArray(preorder, preStart, preEnd) || !inArray(inorder, inStart, inEnd)) {
    			return null;
    		}
    		
    		TreeNode root = new TreeNode(preorder[preStart]);
    		int idx = findIdx(inorder, inStart, inEnd, preorder[preStart]);
    		
    		int leftLen = idx - inStart;
    		
    		TreeNode left = builder(preorder, preStart+1, preStart+leftLen, inorder, inStart, idx-1);
    		TreeNode right = builder(preorder, preStart+leftLen+1, preEnd, inorder, idx+1, inEnd);
    		
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
