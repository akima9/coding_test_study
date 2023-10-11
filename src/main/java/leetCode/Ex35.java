package leetCode;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/create-binary-tree-from-descriptions/description/
public class Ex35 {

    public static void main(String[] args) {
        System.out.println(createBinaryTree(new int[][]{{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}}));
    }
    public static TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            int isLeft = description[2];

            if (!map.containsKey(parent)) {
                map.put(parent, new TreeNode(parent));
            }
            if (!map.containsKey(child)) {
                map.put(child, new TreeNode(child));
            }

            TreeNode node = map.get(parent);
            if (isLeft == 1) {
                node.left = map.get(child);
            } else {
                node.right = map.get(child);
            }

            set.add(child);
        }

        for (int nodeVal : map.keySet()) {
            if (!set.contains(nodeVal)) {
                return map.get(nodeVal);
            }
        }
        return null;
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