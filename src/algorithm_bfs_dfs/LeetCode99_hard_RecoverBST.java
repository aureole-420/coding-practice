package algorithm_bfs_dfs;

 // hard

// https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal
// 看到bst就应该想到in-order traversal给出了顺序序列
// 1，2，3，4，5，6 => 1, <5>, 3, 4, <2>, 6
// 正确的顺序： prev < cur < next
// firstWrongElement: e.g. <5>,    1 < 【<5> >3】 ==== 特征 firstWrongElement > subsequent 
// secondWrongElement: e.g. <2>,   【4 > <2>】 < 6  ==== 特征 prevElem > secondWrongElement 
// 总是先找到
public class LeetCode99_hard_RecoverBST {
	TreeNode prev = null;
//	TreeNode cur = null;
	TreeNode firstWrongElem = null;
	TreeNode secondWrongElem = null;
	
    public void recoverTree(TreeNode root) {
        traverse(root);
        
        if (firstWrongElem != null  && secondWrongElem != null) {
        		int temp = firstWrongElem.val;
        		firstWrongElem.val = secondWrongElem.val;
        		secondWrongElem.val = temp;
        }
    }
    
    private void traverse(TreeNode root) {
    		if (root == null) {
    			return;
    		}
    		
    		traverse(root.left);
    		
    		// start of do some business
    		TreeNode cur = root;
    		if (prev != null) {
    			if (firstWrongElem == null && prev.val >= cur.val) {
    				firstWrongElem = prev;
    			}
    			// 先找到firstWrongElem后才能找secondWrongElem
    			// 注意，secondWrongElem有可能会被赋值两次，只有最后那次才是真的secondWrongElem
    			if (firstWrongElem != null & prev.val >= cur.val) {
    				secondWrongElem = cur;
    			}
    			
    			
    		}
    		prev = cur;
    		// end of do some business
    		
    		traverse(root.right);
    }
    
    // 效率差但简单的方法：inorder traverse tree,得到treeNode 序列，然后把val排序，重新赋给每个treenode
    // 有点这样的意思： 把正确的值依次赋给相应的treenode。
    // https://leetcode.com/problems/recover-binary-search-tree/discuss/32604/18ms-Java-solution-with-in-order-traversal-and-sorting-O(nlogn)-time-and-O(n)-space
}


