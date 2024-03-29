package codingTestStudy;

import java.util.Scanner;

public class ex08_07 {
    static int sum = 0;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int r = in.nextInt();
        System.out.println(solution(n, r));
    }

    public static int solution(int n, int r) {
        int[][] log = new int[n + 1][r + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < r; j++) {
                log[i][j] = 0;
            }
        }
        DFS(n, r, log);
        return sum;
    }

    public static void DFS(int n, int r, int[][] log) {
        if (r == 0) {
            log[n][r] = 1;
            sum += log[n][r];
            return;
        } else if (n == r) {
            log[n][r] = 1;
            log[n + 1][r] = log[n][r - 1] + log[n][r];
            sum += log[n][r];
            return;
        } else if (n < 5 && r < 3 && log[n][r] > 0) {
            sum += log[n][r];
            return;
        } else {
            DFS(n - 1, r - 1, log);
            DFS(n - 1, r, log);
        }
    }
}
//7. 조합의 경우수(메모이제이션)
//설명
//
//Image1.jpg로 계산합니다.
//
//하지만 여러분은 이 공식을 쓰지않고 다음 공식을 사용하여 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.
//
//Image1.jpg
//
//
//입력
//첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.
//
//
//출력
//첫째 줄에 조합수를 출력합니다.
//
//
//예시 입력 1
//
//5 3
//예시 출력 1
//
//10
//예시 입력 2
//
//33 19
//예시 출력 2
//
//818809200