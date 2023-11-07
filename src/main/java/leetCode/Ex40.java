package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Ex40 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
//        Input: land = [[1,0,0],[0,1,1],[0,1,1]]
//        Output: [[0,0,0,0],[1,1,2,2]]
//        System.out.println(findFarmland(new int[][]{
//                {1, 0, 0},
//                {0, 1, 1},
//                {0, 1, 1}}));
        System.out.println(findFarmland(new int[][]{
                {0, 1},
                {1, 0}}));
//        System.out.println(findFarmland(new int[][]{
//                {0}}));
    }

    public static int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        int[][] visit = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> parentList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1 && visit[i][j] != 1) {
                    visit[i][j] = 1;
                    queue.offer(new int[]{i, j});
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    int mx = i;
                    int my = j;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] curPoint = queue.poll();
                            int x = curPoint[0];
                            int y = curPoint[1];
                            for (int l = 0; l < 4; l++) {
                                int nx = x + dx[l];
                                int ny = y + dy[l];
                                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                                if (land[nx][ny] == 0) continue;
                                if (visit[nx][ny] == 1) continue;
                                visit[nx][ny] = 1;
                                queue.offer(new int[]{nx, ny});
                                mx = Math.max(mx, nx);
                                my = Math.max(my, ny);
                            }
                        }
                    }
                    list.add(mx);
                    list.add(my);
                    parentList.add(list);
                }
            }
        }

        int[][] answer;
        if (parentList.size() == 0) {
            answer = new int[0][0];
        } else {
            answer = new int[parentList.size()][parentList.get(0).size()];
        }
        for (int i = 0; i < parentList.size(); i++) {
            answer[i] = parentList.get(i).stream().mapToInt(Integer::intValue).toArray();
        }

        return answer;
    }
}