package leetCode;

//https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
public class Ex06 {
    static int answer;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3)
        );
        System.out.println(minDepth(treeNode));
    }
    public static int minDepth(TreeNode root) {
        answer = Integer.MAX_VALUE;

        if (root == null) {
            return 0;
        } else {
            DFS(root, 1);
            return answer;
        }
    }

    public static void DFS(TreeNode node, int depth) {
        if (node == null) {
            return;
        } else if (node.left == null && node.right == null) {
            answer = Math.min(depth, answer);
            return;
        } else {
            DFS(node.left, depth + 1);
            DFS(node.right, depth + 1);
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
