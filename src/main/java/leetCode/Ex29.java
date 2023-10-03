package leetCode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/all-paths-from-source-to-target/description/
public class Ex29 {
    static List<List<Integer>> answer;

    public static void main(String[] args) {
        System.out.println(allPathsSourceTarget(new int[][]{
                {1, 2},
                {3},
                {3},
                {}
        }));
    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        answer = new ArrayList<>();
        DFS(graph, 0, new ArrayList<>());
        return answer;
    }

    /**
     * @param graph 문제에서 주어진 graph
     * @param index 현재 index
     * @param list answer에 추가 할 왔던 경로 list
     */
    private static void DFS(int[][] graph, int index, List<Integer> list) {
        if (index == graph.length - 1) {
            list.add(index);
            answer.add(new ArrayList<>(list));
            return;
        } else {
            list.add(index);
            for (int nextIndex : graph[index]) {
                DFS(graph, nextIndex, list);
                list.remove(list.size() - 1);
            }
        }
    }
}