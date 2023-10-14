package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1926
public class Ex1 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int max;

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
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] paint = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                paint[i][j] = sc.nextInt();
            }
        }

        int paintCout = 0;
        max = 0;
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paint[i][j] == 1) {
                    paintCout++;
                    queue.offer(new Point(i, j));
                    BFS(queue, paint, m, n);
                }
            }
        }
        System.out.println(paintCout);
        System.out.println(max);
    }

    private static void BFS(Queue<Point> queue, int[][] paint, int m, int n) {
        int paintSize = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curPoint = queue.poll();
                if (curPoint.x < 0 || curPoint.y < 0 || curPoint.x >= n || curPoint.y >= m) continue;
                if (paint[curPoint.x][curPoint.y] != 1) continue;
                paint[curPoint.x][curPoint.y] = 2;
                paintSize++;
                for (int j = 0; j < 4; j++) {
                    queue.offer(new Point(curPoint.x + dx[j], curPoint.y + dy[j]));
                }
            }
        }
        max = Math.max(max, paintSize);
    }
}