package algorithm_ladder_V;

public class SerializeAndDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    		// 用前序遍历来做序列化。string中不包含null
        StringBuilder res = new StringBuilder();
        serializeHelper(root, res);
        return res.toString();
    }
    
    private void serializeHelper(TreeNode root, StringBuilder res) {
    		if (root == null) return;
    		if (res.length() != 0) res.append(",");
    		res.append(root.val);
    		serializeHelper(root.left, res);
    		serializeHelper(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    		// 注意这个corner case
    		if (data.equals("")) return null;
    		
    		String[] vals_string = data.split(",");
    		int[] vals = new int[vals_string.length]; 
    		System.out.println(vals_string.length);
    		for (int i = 0; i< vals_string.length; i++) {
    			System.out.println(vals_string[i]);
    			vals[i] = Integer.parseInt(vals_string[i]);
    		}
        return deserializeHelper(vals, 0, vals.length-1);
    }
    
    private TreeNode deserializeHelper(int[] vals, int start, int end) {
    		if (start > end) return null;
    		
    		int rootVal = vals[start];
    		TreeNode root = new TreeNode(rootVal);
    		
    		// find the FIRST value that larger than rootVal -- index is rightStart
    		// applies to start == end as well
    		int rightStart, i = start + 1;
    		while (i <= end) {
    			if (vals[i] > rootVal) break;
    			i++;
    		}
    		rightStart = i;

    		root.right = deserializeHelper(vals, rightStart, end);
    		root.left = deserializeHelper(vals, start+1, rightStart-1);
    		return root;
    }
    
    public static void main(String[] args) {
    		TreeNode root = new TreeNode(2);
    		root.left = new TreeNode(1);
    		root.right = new TreeNode(4); root.right.left = new TreeNode(3);
    		SerializeAndDeserializeBST codec = new SerializeAndDeserializeBST();
    		System.out.println(codec.serialize(root)); // should be 2,1,4,3
    		
    		//TreeNode rootRecon = codec.deserialize(codec.serialize(root));
    		codec.deserialize("");
    		System.out.println(codec.serialize(null)); // should be 2,1,4,3
    }
}
