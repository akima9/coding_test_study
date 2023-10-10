package leetCode;

public class Ex34 {

    static boolean flag;

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(
//                1,
//                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
//                new TreeNode(2, new TreeNode(4), new TreeNode(3))
//        );
        TreeNode treeNode = new TreeNode(
                1
        );
        System.out.println(isSymmetric(treeNode));
    }

    public static boolean isSymmetric(TreeNode root) {
        flag = true;
        // Tree를 왼쪽, 오른쪽으로 나눈다.
        // 왼쪽은
        return DFS(root.left, root.right);
    }

    private static boolean DFS(TreeNode node1, TreeNode node2) {
        if (!flag) return false;
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            flag = false;
            return false;
        } else {
            if (node1.val == node2.val) {
                boolean left = DFS(node1.left, node2.right);
                boolean right = DFS(node1.right, node2.left);
                return left && right;
            } else {
                flag = false;
                return false;
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