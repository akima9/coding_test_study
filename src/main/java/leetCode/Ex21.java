package leetCode;

//https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/description/
public class Ex21 {

    static TreeNode answer;

    public static void main(String[] args) {
        TreeNode oRoot = new TreeNode(7);
        oRoot.left = new TreeNode(4);
        oRoot.right = new TreeNode(3);
        oRoot.right.left = new TreeNode(6);
        oRoot.right.right = new TreeNode(19);

        TreeNode cRoot = new TreeNode(7);
        cRoot.left = new TreeNode(4);
        cRoot.right = new TreeNode(3);
        cRoot.right.left = new TreeNode(6);
        cRoot.right.right = new TreeNode(19);

        System.out.println(getTargetCopy(oRoot, cRoot, oRoot.right));
    }
    public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        DFS(original, cloned, target);
        return answer;
    }

    public static void DFS(TreeNode origin, TreeNode clone, TreeNode t) {
        if (origin == null) {
            return;
        } else if (origin == t) {
            answer = clone;
        } else {
            DFS(origin.left, clone.left, t);
            DFS(origin.right, clone.right, t);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}