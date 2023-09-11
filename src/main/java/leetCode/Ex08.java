package leetCode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-preorder-traversal/
public class Ex08 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                1,
                null,
                new TreeNode(2, new TreeNode(3), null)
        );
        System.out.println(preorderTraversal(treeNode));
    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        DFS(root, answer);
        return answer;
    }

    public static void DFS(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        } else {
            list.add(node.val);
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