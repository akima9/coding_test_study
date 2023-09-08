package leetCode;

public class Ex04 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        System.out.println(treeNode);
    }
    public static int maxDepth(TreeNode root) {
        DFS(root, 1);
        return 0;
    }
    public static void DFS(TreeNode node, int depth) {
        if (node == null) {
            return;
        } else {
            depth++;
            DFS(node.left, depth);
            DFS(node.right, depth);
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