package leetCode;

import java.util.ArrayList;
import java.util.List;


public class Ex01 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2, left, null);
        TreeNode root = new TreeNode(1, null, right);
        System.out.println(inorderTraversal(root));
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        DFS(root, answer);
        return answer;
    }

    public static void DFS(TreeNode node, List<Integer> list) {
        if (node == null) return;
        else {
            DFS(node.left, list);
            list.add(node.val);
            DFS(node.right, list);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
