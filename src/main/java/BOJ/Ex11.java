package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex11 {
    static int[] dx = {1, 0, -1, 0}; // 상하좌우 방향 이동을 위한 x 좌표 변화
    static int[] dy = {0, 1, 0, -1}; // 상하좌우 방향 이동을 위한 y 좌표 변화

    private static class Point {
        int x;
        int y;
        int isDestroy; // 벽을 부수었는지 여부를 나타내는 변수

        public Point(int x, int y, int isDestroy) {
            this.x = x;
            this.y = y;
            this.isDestroy = isDestroy;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 열
        int M = Integer.parseInt(st.nextToken()); // 행
        int[][] map = new int[N][M]; // 미로
        int[][][] dist = new int[N][M][2]; // 거리 측정 (벽을 부셨을 때/안 부셨을 때)

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String row = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 0)); // 시작점을 큐에 추가하고 벽을 부수지 않았으므로 isDestroy를 0으로 설정
        dist[0][0][0] = 1; // 시작점의 거리를 1로 설정

        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();
            int x = curPoint.x;
            int y = curPoint.y;
            int isDestroy = curPoint.isDestroy;

            // 상하좌우로 이동
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                // 경계를 벗어나지 않도록 체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 벽이 없고, 아직 방문하지 않았다면 거리를 업데이트하고 큐에 추가
                if (map[nx][ny] == 0 && dist[nx][ny][isDestroy] == 0) {
                    dist[nx][ny][isDestroy] = dist[x][y][isDestroy] + 1;
                    queue.offer(new Point(nx, ny, isDestroy));
                }

                // 벽을 부수지 않았고 벽을 만나면 벽을 부순 경우로 처리
                if (isDestroy == 0 && map[nx][ny] == 1 && dist[nx][ny][1] == 0) {
                    dist[nx][ny][1] = dist[x][y][0] + 1;
                    queue.offer(new Point(nx, ny, 1));
                }
            }
        }

        int ans1 = dist[N - 1][M - 1][0]; // 벽을 부수지 않고 도착한 경우의 거리
        int ans2 = dist[N - 1][M - 1][1]; // 벽을 부수고 도착한 경우의 거리

        if (ans1 == 0 && ans2 == 0) {
            System.out.println(-1); // 목적지에 도달할 수 없는 경우
        } else if (ans1 == 0) {
            System.out.println(ans2); // 벽을 부수고 도착한 경우만 가능한 경우
        } else if (ans2 == 0) {
            System.out.println(ans1); // 벽을 부수지 않고 도착한 경우만 가능한 경우
        } else {
            System.out.println(Math.min(ans1, ans2)); // 두 경우 중 더 작은 거리 출력
        }
    }
}
