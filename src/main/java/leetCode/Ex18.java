package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/
public class Ex18 {
    public static void main(String[] args) {
        List<Node> children2 = new ArrayList<>();
        children2.add(new Node(5));
        children2.add(new Node(6));

        List<Node> children = new ArrayList<>();
        children.add(new Node(3, children2));
        children.add(new Node(2));
        children.add(new Node(4));

        Node root = new Node(1, children);

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(Node root) {
        if (root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curNode = queue.poll();
                List<Node> curChildren = curNode.children;
                if (curChildren != null && !curChildren.isEmpty()) {
                    for (Node child : curChildren) {
                        queue.offer(child);
                    }
                }
            }
            level++;
        }
        return level;
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