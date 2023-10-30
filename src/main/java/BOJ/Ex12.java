package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex12 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] paper = new int[M][N];
        int[][] visit = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int ly = Integer.parseInt(st.nextToken());
            int lx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());

            for (int j = lx; j < rx; j++) {
                for (int k = ly; k < ry; k++) {
                    paper[j][k] = 1;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (paper[i][j] == 0 && visit[i][j] == 0) {
                    count++;
                    int sum = 1;
                    visit[i][j] = 1;
                    queue.offer(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] curPoint = queue.poll();
                            int x = curPoint[0];
                            int y = curPoint[1];

                            for (int l = 0; l < 4; l++) {
                                int nx = x + dx[l];
                                int ny = y + dy[l];

                                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                                if (paper[nx][ny] == 1 || visit[nx][ny] == 1) continue;
                                visit[nx][ny] = 1;
                                queue.offer(new int[]{nx, ny});
                                sum++;
                            }
                        }
                    }
                    list.add(sum);
                }
            }
        }
        System.out.println(count);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size() - 1) System.out.print(" ");
        }

    }
}
