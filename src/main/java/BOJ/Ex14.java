package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex14 {
    static int[] ds = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken()); //건물 층수
        int S = Integer.parseInt(st.nextToken()); //현재 층
        int G = Integer.parseInt(st.nextToken()); //목표 층
        int U = Integer.parseInt(st.nextToken()); //up
        int D = Integer.parseInt(st.nextToken()); //down

        if (S == G) {
            System.out.println(0);
            return;
        }
        int[] visit = new int[F + 1];
        Queue<Integer> queue = new LinkedList<>();
        ds[0] = U;
        ds[1] = D * -1;

        visit[S] = 1;
        queue.offer(S);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer s = queue.poll();

                for (int j = 0; j < 2; j++) {
                    int ns = s + ds[j];

                    if (ns == G) {
                        System.out.println(visit[s]);
                        return;
                    }
                    if (ns <= 0 || ns > F) continue;
                    if (visit[ns] >= 1) continue;
                    visit[ns] = visit[s] + 1;
                    queue.offer(ns);
                }
            }
        }
        System.out.println("use the stairs");
    }
}
