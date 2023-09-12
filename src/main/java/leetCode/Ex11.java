package leetCode;

//https://leetcode.com/problems/invert-binary-tree/
public class Ex11 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );
        System.out.println(invertTree(treeNode));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            TreeNode leftNode = root.left;
            root.left = root.right;
            root.right = leftNode;

            invertTree(root.left);
            invertTree(root.right);
            return root;
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