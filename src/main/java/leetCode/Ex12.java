package leetCode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-paths/
public class Ex12 {

    static List<String> answer;

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(
//                1,
//                new TreeNode(2, null, new TreeNode(5)),
//                new TreeNode(3)
//        );
//        TreeNode treeNode = new TreeNode(
//                1
//        );
        TreeNode treeNode = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(5), new TreeNode(6)),
                new TreeNode(3)
        );
        System.out.println(binaryTreePaths(treeNode));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        answer = new ArrayList<>();
        DFS(root, "");
        return answer;
    }

    public static void DFS(TreeNode node, String str) {
        if (node == null) {
            return;
        } else if (node.left == null && node.right == null) {
            answer.add(str + node.val);
        } else {
            DFS(node.left, str + node.val + "->");
            DFS(node.right, str + node.val + "->");
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