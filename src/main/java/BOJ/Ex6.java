package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex6 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); //배추밭 가로
            int N = Integer.parseInt(st.nextToken()); //배추밭 세로
            int K = Integer.parseInt(st.nextToken()); //배추 개수
            int[][] map = new int[N + 1][M + 1]; //배추밭
            int[][] visit = new int[N + 1][M + 1]; //방문 표시
            Queue<int[]> queue = new LinkedList<>();
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                map[Y][X] = 1;
            }
            int count = 0;
            for (int j = 0; j < N + 1; j++) {
                for (int k = 0; k < M + 1; k++) {
                    if (map[j][k] == 1 && visit[j][k] != 1) {
                        count++;
                        queue.offer(new int[]{j, k});
                        visit[j][k] = 1;
                        while (!queue.isEmpty()) {
                            int size = queue.size();
                            for (int l = 0; l < size; l++) {
                                int[] curPoint = queue.poll();
                                int x = curPoint[0];
                                int y = curPoint[1];
                                for (int m = 0; m < 4; m++) {
                                    int nx = x + dx[m];
                                    int ny = y + dy[m];
                                    if (nx < 0 || ny < 0 || nx > N || ny > M) continue;
                                    if (map[nx][ny] == 0) continue;
                                    if (visit[nx][ny] == 1) continue;
                                    queue.offer(new int[]{nx, ny});
                                    visit[nx][ny] = 1;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
