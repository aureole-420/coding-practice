package algorithm_bfs_dfs;


/**
 * 
 * 做这题之前先看116， 重点是操作root 和 root.next； 而不是弄一个辅助函数take两个参数
 *
 *
 * 做后感受： 这题好经典！用dfs做太难做了，见笔记本记录了一个case => recursion假设上一层已经连上了，为curChild寻找它的next，但事实上上一层未必连在一起了。
 * 
 * 这题要用bfs -- 因为有next，所以bfs可以做都O(1) --- level traversal, maintain 每一层第一个节点就可以了
 * traverse current level时，检验左右子数，connect next level
 */
public class LeetCode117_Medium_PopulatingNextRightPointers_III {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		
		TreeLinkNode curHead = root; // head of current level
		
		// every time we visit a level, we connect nodes in next level;
		while (curHead != null) {
			TreeLinkNode nextHead = null; // head of next level;
			TreeLinkNode cur = curHead; // pointer for cur level;
			
			TreeLinkNode preChild = null; // pointer for next level
			TreeLinkNode curChild = null; // pointer for next level
			
			while (cur != null) {
				if (cur.left != null) {
					curChild = cur.left;
					if (nextHead == null) {
						nextHead = cur.left;
					}
					if (preChild != null) {
						preChild.next = curChild;
					}
					preChild = curChild;
				}
				
				if (cur.right != null) {
					curChild = cur.right;
					if (nextHead == null) {
						nextHead = cur.right;
					}
					if (preChild != null) {
						preChild.next = curChild;
					}
					preChild = curChild;
				}
				cur = cur.next;
			}
			
			
			curHead = nextHead;
		}
	}
	
//    public void connect(TreeLinkNode root) {
//        // 
//    		if (root == null) {
//    			return;
//    		}
//    		
//    		if (root.left != null && root.right != null) {
//    			root.left.next = root.right;
//    		}
//    		
//    		TreeLinkNode rootRightestChild = null;
//    		if (root.right != null) {
//    			rootRightestChild = root.right;
//    		} else if (root.left != null) {
//    			rootRightestChild = root.left;
//    		}
//    		
//    		// tricky的点是找完root.next还不够，可能还要找root.next.next, root.next.next.next
//    		TreeLinkNode rootNextLeftestChild = null;
//    		
//    		TreeLinkNode p = root.next;
//    		while (p != null) {
//    			if (p.left != null) {
//    				rootNextLeftestChild = p.left;
//    				break;
//    			} else if (p.right != null) {
//    				rootNextLeftestChild = p.right;
//    				break;
//    			}
//    			
//    			// not found for this node, go to next node
//    			p = p.next;
//    		}
//    	
//    		if (rootRightestChild != null) {
//    			rootRightestChild.next = rootNextLeftestChild;
//    		}
//    		
//    		connect(root.left);
//    		connect(root.right);
//    }
    
}
