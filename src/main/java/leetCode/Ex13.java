package leetCode;

//https://leetcode.com/problems/sum-of-left-leaves/
public class Ex13 {

    static int answer;

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        TreeNode treeNode2 = new TreeNode(
                1
        );
        System.out.println(sumOfLeftLeaves(treeNode1));
        System.out.println(sumOfLeftLeaves(treeNode2));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        answer = 0;
        DFS(root, false);
        return answer;
    }

    public static void DFS(TreeNode node, boolean isLeft) {
        if (node == null) {
            return;
        } else if (node.left == null && node.right == null && isLeft) {
            answer += node.val;
        } else {
            DFS(node.left, true);
            DFS(node.right, false);
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