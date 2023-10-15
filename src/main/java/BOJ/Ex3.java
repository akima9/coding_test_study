package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex3 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] box = new int[N][M];
        int[][] visit = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = sc.nextInt();
            }
        }

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }
        int level = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curPoint = queue.poll();
                if (box[curPoint.x][curPoint.y] == 0) box[curPoint.x][curPoint.y] = 1;
                visit[curPoint.x][curPoint.y] = 1;
                for (int j = 0; j < 4; j++) {
                    if (curPoint.x + dx[j] < 0
                            || curPoint.y + dy[j] < 0
                            || curPoint.x + dx[j] >= N
                            || curPoint.y + dy[j] >= M
                            || visit[curPoint.x + dx[j]][curPoint.y + dy[j]] == 1
                            || box[curPoint.x + dx[j]][curPoint.y + dy[j]] == -1
                    ) continue;
                    queue.offer(new Point(curPoint.x + dx[j], curPoint.y + dy[j]));
                }
            }
            level++;
        }

        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) flag = true;
            }
        }

        if (flag) {
            System.out.println(-1);
        } else {
            System.out.println(level);
        }
    }
}
//6 4
//0 0 0 0 0 0
//0 0 0 0 0 0
//0 0 0 0 0 0
//0 0 0 0 0 1