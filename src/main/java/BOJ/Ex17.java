package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex17 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (K == 0) break;
            if (K < coins[i]) continue;
            int result = K / coins[i];
            resultList.add(result);
            K = K - (result * coins[i]);
        }
        int cnt = 0;
        for (int result : resultList) {
            cnt += result;
        }
        System.out.println(cnt);
    }
}
