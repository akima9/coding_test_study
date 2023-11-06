package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex16 {
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = 0;
        while (true) {
            if (cnt != 0) {
                st = new StringTokenizer(br.readLine());
            }
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken()); //층수
            int R = Integer.parseInt(st.nextToken()); //행
            int C = Integer.parseInt(st.nextToken()); //열

            if (L == 0 && R == 0 && C == 0) return;

            char[][][] building = new char[L][R][C];
            int[][][] visit = new int[L][R][C];
            Queue<int[]> queue = new LinkedList<>();

            for (int i = 0; i < L; i++) {
                if (i != 0) {
                    st = new StringTokenizer(br.readLine());
                }
                for (int j = 0; j < R; j++) {
                    st = new StringTokenizer(br.readLine());
                    String row = st.nextToken();
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = row.charAt(k);
                    }
                }
            }

            String result = BFS(L, R, C, building, visit, queue);
            System.out.println(result);
            cnt++;
        }
    }

    private static String BFS(int L, int R, int C, char[][][] building, int[][][] visit, Queue<int[]> queue) {
        int cnt = 0;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if (building[i][j][k] == 'S') {
                        visit[i][j][k] = 1;
                        queue.offer(new int[]{i, j, k});
                        while (!queue.isEmpty()) {
                            int size = queue.size();
                            for (int l = 0; l < size; l++) {
                                int[] curPoint = queue.poll();
                                int h = curPoint[0];
                                int x = curPoint[1];
                                int y = curPoint[2];
                                for (int m = 0; m < 6; m++) {
                                    int nh = h + dh[m];
                                    int nx = x + dx[m];
                                    int ny = y + dy[m];

                                    if (nh < 0 || nx < 0 || ny < 0 || nh >= L || nx >= R || ny >= C) continue;
                                    if (building[nh][nx][ny] == 'E') {
                                        return "Escaped in " + (cnt + 1) + " minute(s).";
                                    }
                                    if (building[nh][nx][ny] == '#') continue;
                                    if (visit[nh][nx][ny] == 1) continue;
                                    visit[nh][nx][ny] = 1;
                                    queue.offer(new int[]{nh, nx, ny});
                                }
                            }
                            cnt++;
                        }
                    }
                }
            }
        }
        return "Trapped!";
    }
}
//3 4 5
//S....
//.###.
//.##..
//###.#
//
//#####
//#####
//##.##
//##...
//
//#####
//#####
//#.###
//####E
//
//1 3 3
//S##
//#E#
//###
//
//0 0 0