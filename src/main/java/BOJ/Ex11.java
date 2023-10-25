package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex11 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static class Point {
        int x;
        int y;
        int isDestroy;

        public Point(int x, int y, int isDestroy) {
            this.x = x;
            this.y = y;
            this.isDestroy = isDestroy;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //열
        int M = Integer.parseInt(st.nextToken()); //행
        int[][] map = new int[N][M]; //미로
        int[][][] visit = new int[2][N][M]; //방문표시
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String row = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 0));
        visit[0][0][0] = 1;
        visit[1][0][0] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curPoint = queue.poll();
                int x = curPoint.x;
                int y = curPoint.y;

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                    //visit[0] 그냥 통과
                    //visit[1] 부시고 통과

                    if (map[nx][ny] == 1) { //벽을 만나는 경우.
                        if (curPoint.isDestroy == 1) { //전에 부신적 있으면 통과.
                            continue;
                        } else { //전에 부신적 없는 경우.
                            visit[1][nx][ny] = visit[0][x][y] + 1;
                            queue.offer(new Point(nx, ny, 1));
                        }
                    } else { //벽이 아닌 경우
                        if (visit[curPoint.isDestroy][nx][ny] >= 1) continue; //방문 한적 있으면 통과.
                        visit[curPoint.isDestroy][nx][ny] = visit[curPoint.isDestroy][x][y] + 1;
                        queue.offer(new Point(nx, ny, curPoint.isDestroy));
                    }

                    if (nx == N - 1 && ny == M - 1) {
                        int min = Math.min(visit[0][nx][ny], visit[1][nx][ny]);
                        if (min == 0) {
                            System.out.println(Math.max(visit[0][nx][ny], visit[1][nx][ny]));
                        } else {
                            System.out.println(min);
                        }
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
