package leetCode;

//https://leetcode.com/problems/diameter-of-binary-tree/
public class Ex17 {

    static int answer;

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(
//                1,
//                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
//                new TreeNode(3)
//        );
//        TreeNode treeNode = new TreeNode(
//                1,
//                new TreeNode(2),
//                null
//        );
        TreeNode treeNode = new TreeNode(
                4,
                new TreeNode(-7),
                new TreeNode(
                        -3,
                        new TreeNode(
                                -9,
                                new TreeNode(9, new TreeNode(6, new TreeNode(0, null, new TreeNode(-1)), new TreeNode(6, new TreeNode(-4), null)), null),
                                new TreeNode(-7, new TreeNode(-6, new TreeNode(5), null), new TreeNode(-6, new TreeNode(9, new TreeNode(-2), null), null))
                        ),
                        new TreeNode(-3, new TreeNode(-4), null))
        );
        System.out.println(diameterOfBinaryTree(treeNode));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        answer = Integer.MIN_VALUE;
        DFS(root);
        return answer;
    }

    public static int DFS(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftDepth = DFS(node.left);
            int rightDepth = DFS(node.right);

            answer = Math.max(answer, leftDepth + rightDepth);
            return Math.max(leftDepth, rightDepth) + 1;
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