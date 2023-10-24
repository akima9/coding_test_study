package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex9 {
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); //테스트케이스 개수

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken()); //체스판 한변의 길이
            int[][] map = new int[I][I]; //체스판

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); //현재 x좌표
            int y = Integer.parseInt(st.nextToken()); //현재 y좌표
            map[x][y] = 1; //방문 표시
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{x, y});

            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken()); //목표 x좌표
            int ty = Integer.parseInt(st.nextToken()); //목표 y좌표

            System.out.println(BFS(queue, I, map, tx, ty));
        }
    }

    private static int BFS(Queue<int[]> queue, int I, int[][] map, int tx, int ty) {
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] curPoint = queue.poll();
                int cx = curPoint[0];
                int cy = curPoint[1];

                for (int k = 0; k < 8; k++) {
                    int nx = cx + dx[k];
                    int ny = cy + dy[k];

                    if (nx < 0 || ny < 0 || nx >= I || ny >= I) continue;
                    if (map[nx][ny] == 1) continue;
                    if (nx == tx && ny == ty) {
                        return count + 1;
                    }
                    map[nx][ny] = 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
            count++;
        }
        return 0;
    }
}
