package leetCode;

import java.util.HashSet;

public class Ex33 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                5,
                new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(6, null, new TreeNode(7))
        );
        System.out.println(findTarget(treeNode, 9));
    }

    public static boolean findTarget(TreeNode root, int k) {
        // Tree를 DFS로 순회 하면서 node.val을 set에 저장한다.
        // k - node.val이 set에 있다면 true를 return.
        HashSet<Integer> set = new HashSet<>();
        return DFS(root, k, set);
    }

    private static boolean DFS(TreeNode node, int k, HashSet<Integer> set) {
        if (node == null) {
            return false;
        } else {
            if (set.contains(k - node.val)) {
                return true;
            } else {
                set.add(node.val);
            }
            return DFS(node.left, k, set) || DFS(node.right, k, set);
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