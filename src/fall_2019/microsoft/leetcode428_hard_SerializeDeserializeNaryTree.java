package fall_2019.microsoft;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode428_hard_SerializeDeserializeNaryTree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    // Encodes a tree to a single string.
    // A [B,C]  -> "A, 2, B, 0, C, 0"
    public String serialize(Node root) {
        List<String> list = new LinkedList<>();
        serializeHelper(root, list);
        return String.join(",", list);
    }

    private void serializeHelper(Node root, List<String> list) {
        if (root == null) return;
        list.add("" + root.val);
        list.add("" + root.children.size());
        for (Node child: root.children) {
            serializeHelper(child, list);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String[] strings = data.split(",");
        Queue<String> queue = new LinkedList<String>(Arrays.asList(strings));
        return deserializeHelper(queue);
    }

    private Node deserializeHelper(Queue<String> queue) {
        int val = Integer.parseInt(queue.poll());
        int size = Integer.parseInt(queue.poll());

        Node root = new Node(val, new LinkedList<Node>());
        for (int i = 0; i < size; i++) {
            root.children.add(deserializeHelper(queue));
        }

        return root;
    }
}
