package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Ex20 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (i == 0) {
                    A[j] = Integer.parseInt(st.nextToken());
                } else {
                    B[j] = Integer.parseInt(st.nextToken());
                }
            }
        }
        Arrays.sort(A);
        Integer[] b = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(b, Collections.reverseOrder());

        int S = 0;
        for (int i = 0; i < N; i++) {
            S += (A[i] * b[i]);
        }
        System.out.println(S);
    }
}
