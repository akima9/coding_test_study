package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex13 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        int[][] visit = new int[N][N];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String row = st.nextToken();
            for (int j = 0; j < N; j++) {
                map[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }

        int groupCnt = 0;
        ArrayList<Integer> houseCnts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && visit[i][j] != 1) {
                    groupCnt++;
                    visit[i][j] = 1;
                    queue.offer(new int[]{i, j});
                    int houseCnt = 1;

                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] curPoint = queue.poll();
                            int x = curPoint[0];
                            int y = curPoint[1];

                            for (int l = 0; l < 4; l++) {
                                int nx = x + dx[l];
                                int ny = y + dy[l];

                                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                                if (visit[nx][ny] == 1) continue;
                                if (map[nx][ny] == 0) continue;

                                visit[nx][ny] = 1;
                                queue.offer(new int[]{nx, ny});
                                houseCnt++;
                            }
                        }
                    }
                    houseCnts.add(houseCnt);
                }
            }
        }
        System.out.println(groupCnt);
        Collections.sort(houseCnts);
        for (int cnt: houseCnts) {
            System.out.println(cnt);
        }
    }
}
