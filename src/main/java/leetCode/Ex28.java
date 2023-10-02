package leetCode;

//https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
public class Ex28 {

    static int sum;

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(
//                6,
//                new TreeNode(7, new TreeNode(2, new TreeNode(9), null), new TreeNode(7, new TreeNode(1), new TreeNode(4))),
//                new TreeNode(8, new TreeNode(1), new TreeNode(3, null, new TreeNode(5)))
//        );
        TreeNode treeNode = new TreeNode(
                61,
                new TreeNode(13),
                new TreeNode(46, null, new TreeNode(56, new TreeNode(72), null))
        );
        System.out.println(sumEvenGrandparent(treeNode));
    }

    public static int sumEvenGrandparent(TreeNode root) {
        sum = 0;
        DFS(root);
        return sum;
    }

    private static void DFS(TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
            if (node.val % 2 == 0) {
                if (node.left.left != null) sum += node.left.left.val;
                if (node.left.right != null) sum += node.left.right.val;
            }
            DFS(node.left);
        }
        if (node.right != null) {
            if (node.val % 2 == 0) {
                if (node.right.left != null) sum += node.right.left.val;
                if (node.right.right != null) sum += node.right.right.val;
            }
            DFS(node.right);
        }
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}