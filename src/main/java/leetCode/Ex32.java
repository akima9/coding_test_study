package leetCode;

//https://leetcode.com/problems/count-good-nodes-in-binary-tree/
public class Ex32 {

    static int answer;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                3,
                new TreeNode(1, new TreeNode(3), null),
                new TreeNode(4, new TreeNode(1), new TreeNode(5))
        );
        System.out.println(goodNodes(treeNode));

    }
    public static int goodNodes(TreeNode root) {
        answer = 0;
        DFS(root, root.val);
        return answer;
    }

    private static void DFS(TreeNode node, int max) {
        if (node == null) {
            return;
        } else {
            if (node.val >= max) {
                max = node.val;
                answer++;
            }
            DFS(node.left, max);
            DFS(node.right, max);
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