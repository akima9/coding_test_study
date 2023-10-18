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

    /**
     * 불이 퍼지는 속도를 BFS로 구하고,
     * 사람이 이동하는 속도를 BFS로 구한다.
     * 단, 사람은 같은 장소를 불보다 나중에 오거나 동시에 올 수 없다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        int[][] visit = new int[R][C];
        int[][] burn = new int[R][C];
        Queue<int[]> person = new LinkedList<>();
        Queue<int[]> fire = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'J') {
                    person.offer(new int[]{i, j});
                    visit[i][j] = 1;
                } else if (map[i][j] == 'F') {
                    fire.offer(new int[]{i, j});
                    burn[i][j] = 1;
                }
            }
        }

        while (!fire.isEmpty()) {
            int size = fire.size();
            for (int i = 0; i < size; i++) {
                int[] curPoint = fire.poll();
                int x = curPoint[0];
                int y = curPoint[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == '#' || burn[nx][ny] != 0) continue;
                    burn[nx][ny] = burn[x][y] + 1;
                    fire.offer(new int[]{nx, ny});
                }
            }
        }

        while (!person.isEmpty()) {
            int size = person.size();
            for (int i = 0; i < size; i++) {
                int[] curPoint = person.poll();
                int x = curPoint[0];
                int y = curPoint[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                        System.out.println(visit[x][y]);
                        return;
                    }

                    if (visit[nx][ny] != 0 || map[nx][ny] == '#' || visit[x][y] + 1 >= burn[nx][ny] && burn[nx][ny] != 0) continue;
                    visit[nx][ny] = visit[x][y] + 1;
                    person.offer(new int[]{nx, ny});
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
//4 4
//####
//#JF#
//#..#
//#..#
//5 5
//#####
//J..F#
//#...#
//#...#
//##..#
//4 4
//####
//#JF#
//#..#
//#..#