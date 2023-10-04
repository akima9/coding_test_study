package leetCode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/
public class Ex30 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                2,
                new TreeNode(3, new TreeNode(8), new TreeNode(13)),
                new TreeNode(5, new TreeNode(21), new TreeNode(34))
        );
//        TreeNode treeNode = new TreeNode(
//                0,
//                new TreeNode(1, new TreeNode(0, new TreeNode(1), new TreeNode(1)), new TreeNode(0, new TreeNode(1), new TreeNode(1))),
//                new TreeNode(2, new TreeNode(0, new TreeNode(2), new TreeNode(2)), new TreeNode(0, new TreeNode(2), new TreeNode(2)))
//        );
        System.out.println(reverseOddLevels(treeNode));
    }

    public static TreeNode reverseOddLevels(TreeNode root) {
        DFS(root.left, root.right, 1);
        return root;
    }

    private static void DFS(TreeNode node1, TreeNode node2, int level) {
        if (node1 == null) {
            return;
        } else {
            if (level % 2 != 0) {
                int temp = node1.val;
                node1.val = node2.val;
                node2.val = temp;
            }
            DFS(node1.left, node2.right, level + 1);
            DFS(node1.right, node2.left, level + 1);
        }
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