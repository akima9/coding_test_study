package leetCode;

import java.util.ArrayList;

//https://leetcode.com/problems/minimum-distance-between-bst-nodes/
public class Ex25 {

    static ArrayList<Integer> list;

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(
//                4,
//                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
//                new TreeNode(6)
//        );
        TreeNode treeNode = new TreeNode(
                90,
                new TreeNode(69, new TreeNode(49, null, new TreeNode(52)), new TreeNode(89)),
                null
        );
        System.out.println(minDiffInBST(treeNode));
    }

    public static int minDiffInBST(TreeNode root) {
        list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        DFS(root);
        for (int i = list.size() - 1; i > 0; i--) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }

    public static void DFS(TreeNode node) {
        if (node == null) {
            return;
        } else {
            DFS(node.left);
            list.add(node.val);
            DFS(node.right);
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