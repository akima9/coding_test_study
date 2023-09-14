package leetCode;

import java.util.ArrayList;

//https://leetcode.com/problems/minimum-absolute-difference-in-bst/
public class Ex16 {

    static int min;

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(
//                4,
//                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
//                new TreeNode(6)
//        );
//        TreeNode treeNode = new TreeNode(
//                1,
//                new TreeNode(0),
//                new TreeNode(48, new TreeNode(12), new TreeNode(49))
//
//        );
        TreeNode treeNode = new TreeNode(
                236,
                new TreeNode(104, null, new TreeNode(227)),
                new TreeNode(701, null, new TreeNode(911))

        );
//        9
        System.out.println(getMinimumDifference(treeNode));
    }

    public static int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        DFS(root, list);
        return min;
    }

    public static void DFS(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        } else {
            list.add(node.val);
            if (node.left != null) {
                for (int e : list) {
                    min = Math.min(min, Math.abs(e - node.left.val));
                }
            }
            if (node.right != null) {
                for (int e : list) {
                    min = Math.min(min, Math.abs(e - node.right.val));
                }
            }
            DFS(node.left, list);
            DFS(node.right, list);
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