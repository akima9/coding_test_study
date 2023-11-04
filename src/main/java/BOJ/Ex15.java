package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex15 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];


        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                set.add(map[i][j]);
            }
        }

        int max = Integer.MIN_VALUE;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int h = iterator.next() - 1;
            int[][] visit = new int[N][N];
            Queue<int[]> queue = new LinkedList<>();
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > h && visit[i][j] != 1) {
                        visit[i][j] = 1;
                        queue.offer(new int[]{i, j});
                        cnt++;
                        while (!queue.isEmpty()) {
                            int size = queue.size();
                            for (int k = 0; k < size; k++) {
                                int[] curPoint = queue.poll();
                                int x = curPoint[0];
                                int y = curPoint[1];
                                for (int l = 0; l < 4; l++) {
                                    int nx = x + dx[l];
                                    int ny = y + dy[l];
                                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                                    if (map[nx][ny] <= h) continue;
                                    if (visit[nx][ny] == 1) continue;
                                    visit[nx][ny] = 1;
                                    queue.offer(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}
