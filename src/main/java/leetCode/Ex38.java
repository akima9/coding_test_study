package leetCode;

public class Ex38 {

    static int max;
    static TreeNode answerNode;

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(
//                3,
//                new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
//                new TreeNode(1, new TreeNode(0), new TreeNode(8))
//        );
        TreeNode treeNode = new TreeNode(1);
        System.out.println(lcaDeepestLeaves(treeNode));
    }

    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        max = Integer.MIN_VALUE;
        answerNode = new TreeNode();
        DFS(root, 0);
        return answerNode;
    }

    private static void DFS(TreeNode node, int depth) {
        if (node == null) {
            return;
        } else if (depth > 0 && node.left == null && node.right == null) {
            return;
        } else {
            DFS(node.left, depth + 1);
            DFS(node.right, depth + 1);

            if (node.left != null && node.right == null) {
                if (max < depth) {
                    max = depth;
                    answerNode = node.left;
                }
            } else if (node.left == null && node.right != null) {
                if (max < depth) {
                    max = depth;
                    answerNode = node.right;
                }
            } else {
                if (max < depth) {
                    max = depth;
                    answerNode = node;
                }
            }
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