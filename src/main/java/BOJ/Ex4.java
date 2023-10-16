package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex4 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'J' || map[i][j] == 'F') {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int result = BFS(queue, R, C, map);
        if (result > 0) {
            System.out.println(result + 1);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    private static int BFS(Queue<int[]> queue, int R, int C, char[][] map) {
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curPoint = queue.poll();
                int x = curPoint[0];
                int y = curPoint[1];

                if (x == 0 || y == 0 || x == R - 1 || y == C - 1) {
                    return level;
                }

                if (map[x][y] == 'J') {
                    map[x][y] = '.';
                    for (int j = 0; j < 4; j++) {
                        int nx = x + dx[j];
                        int ny = y + dy[j];
                        if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] != '.') continue;
                        queue.offer(new int[]{nx, ny});
                        map[nx][ny] = 'J';
                    }
                } else if (map[x][y] == 'F') {
                    for (int j = 0; j < 4; j++) {
                        int nx = x + dx[j];
                        int ny = y + dy[j];
                        if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] != '.') continue;
                        if (map[nx][ny] == 'J') {
                            return 0;
                        }
                        queue.offer(new int[]{nx, ny});
                        map[nx][ny] = 'F';
                    }
                }

            }
            level++;
        }
        return 0;
    }
}
//4 4
//####
//#JF#
//#..#
//#..#
//5 5
//#####
//#JF.#
//#...#
//##..#
//##..#
//4 4
//####
//#JF#
//#..#
//#..#