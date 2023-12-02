package BOJ.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] ints = new int[N];
        int[] order = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            ints[i] = x;
            order[i] = x;
        }
        int[] arr = Arrays.stream(ints).distinct().toArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int e : order) {
            int num = Arrays.binarySearch(arr, e);
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
//5
//2 4 -10 4 -9