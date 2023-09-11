package leetCode;

//https://leetcode.com/problems/count-complete-tree-nodes/description/
public class Ex10 {
    static int answer;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), null)
        );
        TreeNode treeNode1 = new TreeNode();

//        System.out.println(countNodes(treeNode));
        System.out.println(countNodes(treeNode1));
    }

    public static int countNodes(TreeNode root) {
        answer = 0;
        DFS(root);
        return answer;
    }

    public static void DFS(TreeNode node) {
        if (node == null || node.val == 0) {
            return;
        } else {
            answer++;
            DFS(node.left);
            DFS(node.right);
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