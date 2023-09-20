package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Ex19 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(
                1,
                new TreeNode(3, new TreeNode(5), null),
                new TreeNode(2)
        );
        TreeNode root2 = new TreeNode(
                2,
                new TreeNode(1, null, new TreeNode(4)),
                new TreeNode(3, null, new TreeNode(7))
        );
        System.out.println(mergeTrees(root1, root2));
    }
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root2.val = root1.val + root2.val;
        root2.left = mergeTrees(root1.left, root2.left);
        root2.right = mergeTrees(root1.right, root2.right);

        return root2;
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