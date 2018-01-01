package algorithm_ladder_V;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import algorithm_ladder_IV.TreeNode;

/*
 * 1. 使用了preorder traversal的序列
 * 2. 反序列化较难。这里用了一个queue，使得递归可以顺利实现。
 * 2.* 除了queue，可以直接操作String array（需要一个额外的field来给array计数）
 * 2.* 另外可以用StringTokenizer
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        serializeHelper(root, res);
        return res.toString();
    }
    
    /*  
     * Result is: 1,4,#,#,2,3,#,#,#  <-> 1 + ,4  + ,# + ,# + ,2 + ,3 + ,# + ,# + ,#
     * Notice that if comma is put after integer then there is no way to eliminate the last comma.
     */
    private void serializeHelper(TreeNode root, StringBuilder res) {
    
    		if (res.length() > 0) res.append(","); // the root has not comma ahead.
    		
    		if (root == null) {  
    			res.append("#");
    			return;
    			}
    		
    		res.append(root.val);
    		serializeHelper(root.left, res);
    		serializeHelper(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    		String[] vals = data.split(",");
    		System.out.println(vals.length);
    		LinkedList<String> queue = new LinkedList<String>();
    		queue.addAll(Arrays.asList(vals));
//    		for (String s : vals) 
//    			queue.offer(s);
    			
    		return deserializeHelper(queue);
    }
    
    private TreeNode deserializeHelper( LinkedList<String> queue) {
    		if (queue.isEmpty()) return null;
    		
    		String val = queue.poll();
    		if (val.equals("#")) return null;
    		
    		// else val is an integer
    		TreeNode root = new TreeNode(Integer.parseInt(val));
    		root.left = deserializeHelper(queue);
    		root.right = deserializeHelper(queue);
    		
    		return root;
    }
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.left = new TreeNode(4);
		SerializeAndDeserializeBinaryTree codec = new SerializeAndDeserializeBinaryTree();
		System.out.println(codec.serialize(root));
		//System.out.println(codec.deserialize(codec.serialize(root))); // should 9
		TreeNode reconRoot = codec.deserialize(codec.serialize(root));
		System.out.println(codec.serialize(reconRoot));
	}
}
