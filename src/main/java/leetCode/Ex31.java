package leetCode;

//https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/description/
public class Ex31 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                -1,
                null,
                new TreeNode(-1)
        );
        FindElements findElements = new FindElements(treeNode);
        System.out.println(findElements.find(1));
        System.out.println(findElements.find(2));
    }
    private static class FindElements {

        TreeNode tree;
        static boolean answer = false;

        public FindElements(TreeNode root) {
            root.val = 0;
            changeTree(root);
            tree = root;
        }

        public boolean find(int target) {
            answer = false;
            findTarget(tree, target);
            return answer;
        }

        private static void findTarget(TreeNode node, int target) {
            if (answer) return;
            if (node == null) {
                return;
            } else {
                if (node.val == target) {
                    answer = true;
                    return;
                }
                findTarget(node.left, target);
                findTarget(node.right, target);
            }
        }

        private static void changeTree(TreeNode node) {
            if (node == null) {
                return;
            } else {
                if (node.left != null) node.left.val = 2 * node.val + 1;
                if (node.right != null) node.right.val = 2 * node.val + 2;
                changeTree(node.left);
                changeTree(node.right);
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