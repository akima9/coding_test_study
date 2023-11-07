package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ex39 {
    public static void main(String[] args) {
        ArrayList<Node> nodes1 = new ArrayList<>();
        nodes1.add(new Node(5));
        nodes1.add(new Node(6));

        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(new Node(3, nodes1));
        nodes.add(new Node(2));
        nodes.add(new Node(4));

        Node node = new Node(1, nodes);
        System.out.println(levelOrder(node));
    }

    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            List<List<Integer>> parentList = new ArrayList<>();
            return parentList;
        }
        List<List<Integer>> parentList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        parentList.add(temp);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node curNode = queue.poll();
                List<Node> children = curNode.children;

                if (children == null) continue;

                for (Node nextNode : children) {
                    queue.offer(nextNode);
                    list.add(nextNode.val);
                }
            }
            if (!list.isEmpty()) {
                parentList.add(list);
            }
        }

        return parentList;
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}