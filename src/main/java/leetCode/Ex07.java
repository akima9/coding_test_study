package leetCode;

//https://leetcode.com/problems/path-sum/description/
public class Ex07 {
    static boolean answer;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                1,
                new TreeNode(2),
                null
        );
        System.out.println(hasPathSum(treeNode, 1));
    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        answer = false;
        if (root == null) return answer;
        DFS(root, targetSum, 0);
        return answer;
    }

    public static void DFS(TreeNode node, int targetSum, int sum) {
        if (answer) {
            return;
        } else if (node == null) {
            return;
        } else if (node.left == null && node.right == null) {
            answer = targetSum == sum + node.val;
            return;
        } else {
            DFS(node.left, targetSum, sum + node.val);
            DFS(node.right, targetSum, sum + node.val);
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