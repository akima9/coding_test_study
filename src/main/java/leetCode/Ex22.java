package leetCode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/univalued-binary-tree/description/
public class Ex22 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                2,
                new TreeNode(2, new TreeNode(5), new TreeNode(2)),
                new TreeNode(2)
        );
        System.out.println(isUnivalTree(treeNode));
    }

    public static boolean isUnivalTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (root.val != curNode.val) return false;
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
        }
        return true;
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