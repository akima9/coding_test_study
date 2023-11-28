package BOJ.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정수의 개수
        int[] ints = new int[N]; // 입력 받는 정수를 담을 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ints); // 입력 받은 정수 배열을 오름차순 정렬

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 타겟 숫자 개수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken()); // 타겟 숫자
            int start = 0;
            int end = N - 1;
            boolean hasNotTarget = true;

            while (start <= end) {
                int mid = (start + end) / 2;
                if (ints[mid] == target) {
                    System.out.println(1);
                    hasNotTarget = false;
                    break;
                } else if (ints[mid] < target) {
                    start = mid + 1;
                } else if (ints[mid] > target) {
                    end = mid - 1;
                }
            }

            if (hasNotTarget) {
                System.out.println(0);
            }
        }
    }
}
