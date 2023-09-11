package leetCode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-postorder-traversal/
public class Ex09 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                1,
                null,
                new TreeNode(2, new TreeNode(3), null)
        );
        System.out.println(postorderTraversal(treeNode));
    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        DFS(root, answer);
        return answer;
    }

    public static void DFS(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        } else {
            DFS(node.left, list);
            DFS(node.right, list);
            list.add(node.val);
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