package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] check = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();
                if (cur == K) {
                    System.out.println(time);
                    return;
                }

                int plus = cur + 1;
                int minus = cur - 1;
                int multi = cur * 2;

                if (plus <= 100000 && check[plus] != 1) {
                    queue.offer(plus);
                    check[plus] = 1;
                }

                if (minus >= 0 && check[minus] != 1) {
                    queue.offer(minus);
                    check[minus] = 1;
                }

                if (multi <= 100000 && check[multi] != 1) {
                    queue.offer(multi);
                    check[multi] = 1;
                }
            }
            time++;
        }
    }
}
