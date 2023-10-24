package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex10 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); //테스트케이스 수
        for (int i = 0; i < T; i++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            char[][] map = new char[h][w];

            Queue<int[]> personQ = new LinkedList<>();
            Queue<int[]> fireQ = new LinkedList<>();
            int[][] visit = new int[h][w];
            int[][] burn = new int[h][w];

            for (int j = 0; j < h; j++) {
                st = new StringTokenizer(br.readLine());
                String row = st.nextToken();
                for (int k = 0; k < w; k++) {
                    map[j][k] = row.charAt(k);
                    if (map[j][k] == '@') {
                        personQ.offer(new int[]{j, k});
                        visit[j][k] = 1;
                    }
                    if (map[j][k] == '*') {
                        fireQ.offer(new int[]{j, k});
                        burn[j][k] = 1;
                    }
                }
            }

            while (!fireQ.isEmpty()) {
                int size = fireQ.size();
                for (int j = 0; j < size; j++) {
                    int[] curPoint = fireQ.poll();
                    int x = curPoint[0];
                    int y = curPoint[1];

                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];

                        if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                        if (map[nx][ny] == '#') continue;
                        if (burn[nx][ny] >= 1) continue;
                        fireQ.offer(new int[]{nx, ny});
                        burn[nx][ny] = burn[x][y] + 1;
                    }
                }
            }

            answer = personBFS(personQ, h, w, visit, map, burn);
            if (answer > 0) {
                System.out.println(answer);
            } else {
                System.out.println("IMPOSSIBLE");
            }

        }
    }

    private static int personBFS(Queue<int[]> personQ, int h, int w, int[][] visit, char[][] map, int[][] burn) {
        while (!personQ.isEmpty()) {
            int size = personQ.size();
            for (int j = 0; j < size; j++) {
                int[] curPoint = personQ.poll();
                int x = curPoint[0];
                int y = curPoint[1];

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        return visit[x][y];
                    }
                    if (map[nx][ny] == '#') continue;
                    if (visit[nx][ny] >= 1) continue;
                    if (burn[nx][ny] != 0 && burn[nx][ny] <= visit[x][y] + 1) continue;
                    personQ.offer(new int[]{nx, ny});
                    visit[nx][ny] = visit[x][y] + 1;
                }
            }
        }
        return 0;
    }
}
