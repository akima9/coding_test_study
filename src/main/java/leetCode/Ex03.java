package leetCode;

public class Ex03 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));
        System.out.println(isSymmetric(root));
    }
    public static boolean isSymmetric(TreeNode root) {
        return DFS(root.left, root.right);
    }

    public static boolean DFS(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left != null && right == null || left == null && right != null) return false;

        return DFS(left.left, right.right) && DFS(left.right, right.left) && left.val == right.val;
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