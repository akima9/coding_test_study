package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex7 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char[][] paint = new char[N][N];
        char[][] rgPaint = new char[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String row = st.nextToken();
            for (int j = 0; j < N; j++) {
                paint[i][j] = row.charAt(j);

                if (row.charAt(j) == 'G') {
                    rgPaint[i][j] = 'R';
                } else {
                    rgPaint[i][j] = row.charAt(j);
                }
            }
        }
        Queue<int[]> redQueue = new LinkedList<>();
        Queue<int[]> greenQueue = new LinkedList<>();
        Queue<int[]> blueQueue = new LinkedList<>();
        Queue<int[]> redGreenQueue = new LinkedList<>();
        int[][] redVisit = new int[N][N];
        int[][] greenVisit = new int[N][N];
        int[][] blueVisit = new int[N][N];
        int[][] redGreenVisit = new int[N][N];
        int count = 0;
        int rgCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (paint[i][j] == 'R' && redVisit[i][j] != 1) {
                    redQueue.offer(new int[]{i, j});
                    redVisit[i][j] = 1;
                    count++;
                    BFS(redQueue, N, paint, redVisit, 'R');
                }
                if (paint[i][j] == 'G' && greenVisit[i][j] != 1) {
                    greenQueue.offer(new int[]{i, j});
                    greenVisit[i][j] = 1;
                    count++;
                    BFS(greenQueue, N, paint, greenVisit, 'G');
                }
                if (paint[i][j] == 'B' && blueVisit[i][j] != 1) {
                    blueQueue.offer(new int[]{i, j});
                    blueVisit[i][j] = 1;
                    count++;
                    rgCount++;
                    BFS(blueQueue, N, paint, blueVisit, 'B');
                }
                if (rgPaint[i][j] == 'R' && redGreenVisit[i][j] != 1) {
                    redGreenQueue.offer(new int[]{i, j});
                    redGreenVisit[i][j] = 1;
                    rgCount++;
                    BFS(redGreenQueue, N, rgPaint, redGreenVisit, 'R');
                }
            }
        }
        System.out.println(count + " " + rgCount);
    }

    private static void BFS(Queue<int[]> queue, int N, char[][] paint, int[][] visit, char C) {
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
                    if (paint[nx][ny] != C) continue;
                    if (visit[nx][ny] == 1) continue;
                    queue.offer(new int[]{nx, ny});
                    visit[nx][ny] = 1;
                }
            }
        }
    }
}
