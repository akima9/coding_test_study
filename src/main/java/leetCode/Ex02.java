package leetCode;

import java.util.ArrayList;

public class Ex02 {
    public static void main(String[] args) {
        TreeNode treeNodePLeft = new TreeNode(-685);
        TreeNode treeNodePRight = new TreeNode(2970);
        TreeNode treeNodeP = new TreeNode(5, treeNodePLeft, treeNodePRight);

        TreeNode treeNodeQLeft = new TreeNode(-685);
        TreeNode treeNodeQRight = new TreeNode(2970);
        TreeNode treeNodeQ = new TreeNode(5, treeNodeQLeft, treeNodeQRight);

        System.out.println(isSameTree(treeNodeP, treeNodeQ));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayList<Integer> pList = new ArrayList<>();
        ArrayList<Integer> qList = new ArrayList<>();

        DFS(p, pList);
        DFS(q, qList);

        if (pList.size() != qList.size()) {
            return false;
        } else {
            for (int i = 0; i < pList.size(); i++) {
                if (pList.get(i) != qList.get(i)) {
                    if (pList.get(i) == null || qList.get(i) == null) {
                        return false;
                    }
                    if (pList.get(i).compareTo(qList.get(i)) != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void DFS(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            list.add(null);
            return;
        } else {
            list.add(node.val);
            DFS(node.left, list);
            DFS(node.right, list);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}