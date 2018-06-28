package algorithm_tree;
import java.util.*;


// 做前，first find the CLOSEST，然后2 pass in order traversal -- 找到K个potential successor和 k个predecessor，然后two pointers向左右走

// 做中： 看；额最高票答案，two stack正序反序装predecessor and sucessor, 然后依次从两个stack pop， 跟我的差不多？也是O(n)

// 做中2: 看到一个maxStack的解法 --- 虽然复杂度并没有太大优势，O(（）logk),最坏情况至少有一大半的节点node都要经过pq的offer and poll 
// --- 不过对实现用pq过滤BST有启发， BST的iterator是in order的； 那么加pq过滤也是一样，pq作为参数传入filter，然后inorder filter

// 做中3: 要求less than O(n) run time!!! 当n很大时
public class LeetCode272_ClosestBSTValue_II {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        
    }
}
