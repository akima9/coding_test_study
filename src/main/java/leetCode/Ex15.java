package leetCode;

import java.util.ArrayList;
import java.util.HashMap;

//https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
public class Ex15 {

    static HashMap<Integer, Integer> map;

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(
//                1,
//                null,
//                new TreeNode(2, new TreeNode(2), null)
//        );
        TreeNode treeNode = new TreeNode(
                0
        );
        System.out.println(findMode(treeNode));
    }

    public static int[] findMode(TreeNode root) {
        map = new HashMap<>();

        DFS(root);

        int max = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            int curValue = map.get(key);
            max = Math.max(curValue, max);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            int curValue = map.get(key);
            if (max == map.get(key)) {
                list.add(key);
            }
        }

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static void DFS(TreeNode node) {
        if (node == null) {
            return;
        } else {
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            DFS(node.left);
            DFS(node.right);
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