package leetCode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/cousins-in-binary-tree/
public class Ex26 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3)
        );
        System.out.println(isCousins(treeNode, 4, 3));
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        int xLevel = 0;
        int yLevel = 0;
        TreeNode xRoot = new TreeNode();
        TreeNode yRoot = new TreeNode();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null && curNode.left.val == x) {
                    xLevel = level + 1;
                    xRoot = curNode;
                }
                if (curNode.right != null && curNode.right.val == x) {
                    xLevel = level + 1;
                    xRoot = curNode;
                }
                if (curNode.left != null && curNode.left.val == y) {
                    yLevel = level + 1;
                    yRoot = curNode;
                }
                if (curNode.right != null && curNode.right.val == y) {
                    yLevel = level + 1;
                    yRoot = curNode;
                }
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
            level++;
        }
        return (xLevel == yLevel && xRoot != yRoot);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}