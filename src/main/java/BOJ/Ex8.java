package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex8 {
    static int[] dh = {1, 0, 0, -1, 0, 0};
    static int[] dy = {0, 1, 0, 0, -1, 0};
    static int[] dx = {0, 0, 1, 0, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] box = new int[H][N][M];
        int[][][] visit = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                        visit[i][j][k] = 1;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int l = 0; l < size; l++) {
                int[] curPoint = queue.poll();
                int h = curPoint[0];
                int y = curPoint[1];
                int x = curPoint[2];

                for (int m = 0; m < 6; m++) {
                    int nh = h + dh[m];
                    int ny = y + dy[m];
                    int nx = x + dx[m];

                    if (nh < 0 || ny < 0 || nx < 0 || nh >= H || ny >= N || nx >= M) continue;
                    if (box[nh][ny][nx] == 1) continue;
                    if (box[nh][ny][nx] == -1) continue;
                    queue.offer(new int[]{nh, ny, nx});
                    box[nh][ny][nx] = 1;
                    visit[nh][ny][nx] = visit[h][y][x] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, visit[i][j][k]);
                }
            }
        }

        System.out.println(max - 1);
    }
}