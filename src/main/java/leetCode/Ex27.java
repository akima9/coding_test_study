package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/deepest-leaves-sum/
public class Ex27 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(4, new TreeNode(7), null), new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(6, null, new TreeNode(8)))
        );
        System.out.println(deepestLeavesSum(treeNode));
    }

    public static int deepestLeavesSum(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
                sum += curNode.val;
            }
            list.add(level, sum);
            level++;
        }
        return list.get(list.size() - 1);
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