package algorithm_tree;
import java.util.*;


// 做前，first find the CLOSEST，然后2 pass in order traversal -- 找到K个potential successor和 k个predecessor，然后two pointers向左右走

// 做中： 看；额最高票答案，two stack正序反序装predecessor and sucessor, 然后依次从两个stack pop， 跟我的差不多？也是O(n)

// 做中2: 看到一个maxStack的解法 --- 虽然复杂度并没有太大优势，O(（）logk),最坏情况至少有一大半的节点node都要经过pq的offer and poll 
// --- 不过对实现用pq过滤BST有启发， BST的iterator是in order的； 那么加pq过滤也是一样，pq作为参数传入filter，然后inorder filter

// 做中3: 要求less than O(n) run time!!! 当n很大时
// 看了排名第二的答案，超棒！
// 这题跟173很像，173是给出bst的iterator （O(logn) space, worst case O(logn) time）
// 这题是要构造某个given target的successor / predecessor iterator
public class LeetCode272_hard_ClosestBSTValue_II {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
    		List<Integer> res = new ArrayList<>();
    		
        Stack<TreeNode> succ = new Stack<>();
        Stack<TreeNode> pred = new Stack<>();
        initializeSucessorStack(root, target, succ);
        initializePredecessorStack(root, target, pred);
        
        // deal with 重复元素
        if (!pred.isEmpty() && !succ.isEmpty() && pred.peek().val == target) {
        		getNextPredecessor(pred);
        }
        
        while (k-- > 0) {
        		if (succ.isEmpty()) {
        			res.add(getNextPredecessor(pred));
        		} else if (pred.isEmpty()) {
        			res.add(getNextSuccessor(succ));
        		} else {
        			double succ_diff = Math.abs(target - succ.peek().val);
        			double pred_diff = Math.abs(target - pred.peek().val);
        			
        			if (succ_diff < pred_diff) {
        				res.add(getNextSuccessor(succ));
        			} else {
        				res.add(getNextPredecessor(pred));
        			}
        		}
        }
        
        return res;
    }
    
    // 从root开始搜索，找到最近的那个successor
    private void initializeSucessorStack(TreeNode root, double target, Stack<TreeNode> succ) {
    		if (root == null) {
    			return;
    		}
    		
    		while (root != null) {
        		if (root.val == target) {
        			succ.push(root);
        			break;
        		} else if (root.val > target) {
        			succ.push(root);
        			root = root.left;
        		} else {
        			root = root.right;
        		}
    		}

    }
    
    private void initializePredecessorStack(TreeNode root, double target, Stack<TreeNode> pred) {
    		if (root == null) {
    			return;
    		}
    		
    		 while (root != null) {
    			 if (root.val == target) {
    				 pred.push(root);
    				 break;
    			 } else if (root.val < target) {
    				 pred.push(root);
    				 root = root.right;
    			 } else { // target < root.val
    				 root = root.left;
    			 }
    		 }
    }
    
    // 下一个数是右子树的最左支。
    private int getNextSuccessor(Stack<TreeNode> succ) {
    		TreeNode cur = succ.pop();
    		
    		TreeNode ptr = cur.right;
    		while (ptr != null) {
    			succ.push(ptr);
    			ptr = ptr.left;
    		}
    		
    		return cur.val;
    }
    
    // 上一个数是左子树的最右支
    private int getNextPredecessor(Stack<TreeNode> pred) {
    		TreeNode cur = pred.pop();
    		
    		TreeNode ptr = cur.left;
    		while (ptr != null) {
    			pred.push(ptr);
    			ptr = ptr.right;
    		}
    		
    		return cur.val;
    }

}
