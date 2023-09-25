package leetCode;

import java.util.HashSet;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
public class Ex24 {
    static HashSet<Integer> set;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                5,
                new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(6, null, new TreeNode(7))
        );

        System.out.println(findTarget(treeNode, 9));
    }
    public static boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        return DFS(root, k);
    }

    public static boolean DFS(TreeNode root, int k) {
        if (root == null) {
            return false;
        } else {
            if (set.contains(k - root.val)) {
                return true;
            } else {
                set.add(root.val);
            }
            return DFS(root.left, k) || DFS(root.right, k);
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