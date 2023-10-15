package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2178
public class Ex2 {
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
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] charArray = sc.next().toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                map[i][j] = Character.getNumericValue(charArray[j]);
            }
        }

        int answer = BFS(N, M, map);
        System.out.println(answer);
    }

    private static int BFS(int N, int M, int[][] map) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curPoint = queue.poll();
                if (curPoint.x < 0 || curPoint.y < 0 || curPoint.x >= N || curPoint.y >= M) continue;
                if (map[curPoint.x][curPoint.y] != 1) continue;

                map[curPoint.x][curPoint.y] = 2;
                for (int j = 0; j < 4; j++) {
                    queue.offer(new Point(curPoint.x + dx[j], curPoint.y + dy[j]));
                }

                if (curPoint.x == N - 1 && curPoint.y == M -1) return count;
            }
            count++;
        }
        return count;
    }
}
//4 6
//101111
//101010
//101011
//111011