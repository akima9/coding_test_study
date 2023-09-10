package leetCode;

//https://leetcode.com/problems/balanced-binary-tree/
public class Ex05 {
    static int leftMaxDepth;
    static int rightMaxDepth;
    static boolean isBalanced = true;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null),
                new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4)))
        );
        System.out.println(isBalanced(treeNode));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        leftMaxDepth = Integer.MIN_VALUE;
        rightMaxDepth = Integer.MIN_VALUE;

        DFS(root.left, 0, true);
        DFS(root.right, 0, false);

        return Math.abs(leftMaxDepth - rightMaxDepth) <= 1 && isBalanced;
    }

    public static void DFS(TreeNode node, int depth, boolean isLeft) {
        if (node == null) {
            if (isLeft) {
                leftMaxDepth = Math.max(depth, leftMaxDepth);
            } else {
                rightMaxDepth = Math.max(depth, rightMaxDepth);
            }
            return;
        } else if (node.left == null && node.right != null || node.left != null && node.right == null) {
            isBalanced = false;
            return;
        } else if (isBalanced){
            depth++;
            DFS(node.left, depth, isLeft);
            DFS(node.right, depth, isLeft);
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