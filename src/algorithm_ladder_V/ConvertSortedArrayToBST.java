package algorithm_ladder_V;

public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] A) {
    		if (A == null) return null;
    		
    		return buildBST(A, 0, A.length-1);
    }
    
    private TreeNode buildBST(int[] A, int start, int end) {
    		if (start > end) return null;
    		
    		int mid = start + (end - start) / 2;
    		TreeNode root = new TreeNode(A[mid]);
    		root.left = buildBST(A, start, mid-1);
    		root.right = buildBST(A, mid+1, end);
    		
    		return root;
    }
}
