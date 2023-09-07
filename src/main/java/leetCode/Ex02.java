package leetCode;

import java.util.ArrayList;

public class Ex02 {
    static ArrayList<Integer> pList = new ArrayList<>();
    static ArrayList<Integer> qList = new ArrayList<>();
    //Input: p = [1,2,3], q = [1,2,3]
    //Output: true
    //
    //Input: p = [1,2], q = [1,null,2]
    //Output: false
    public static void main(String[] args) {
        TreeNode treeNodePLeft = new TreeNode(2);
        TreeNode treeNodePRight = new TreeNode(3);
        TreeNode treeNodeP = new TreeNode(1, treeNodePLeft, null);

        TreeNode treeNodeQLeft = new TreeNode(2);
        TreeNode treeNodeQRight = new TreeNode(2);
        TreeNode treeNodeQ = new TreeNode(1, null, treeNodeQRight);

        System.out.println(isSameTree(treeNodeP, treeNodeQ));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        DFS(p, pList);
        DFS(q, qList);

        if (pList.size() != qList.size()) {
            return false;
        } else {
            for (int i = 0; i < pList.size(); i++) {
                if (pList.get(i) != qList.get(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void DFS(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            list.add(0);
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
//class Solution {
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//
//    }
//}
//

