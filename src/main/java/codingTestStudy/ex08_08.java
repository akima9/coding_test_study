package codingTestStudy;

import java.util.Arrays;
import java.util.Scanner;

public class ex08_08 {
    static int N;
    static int F;
    static int[] C;
    static int[] A;
    static boolean flag = false;
    static int[] check;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        F = in.nextInt();
        C = new int[N];
        A = new int[N];
        int[][] log = new int[N][N];
        check = new int[N + 1];
        for (int i = 0; i < N; i++) {
            C[i] = combi(N - 1, i, log);
        }
        DFS(0, 0);
    }
    public static void DFS(int index, int sum) {
        if (flag) return;
        if (index == N) {
            if (sum == F) {
                for (int a : A) {
                    System.out.print(a + " ");
                }
                flag = true;
            }
        } else {
            for (int i = 1; i <= N; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    A[index] = i;
                    DFS(index + 1, sum + (C[index] * A[index]));
                    check[i] = 0;
                }
            }
        }
    }
    public static int combi(int n, int r, int[][] log) {
        if (log[n][r] > 0) return log[n][r];
        if (r == 0 || n == r) {
            return log[n][r] = 1;
        } else {
            return combi(n - 1, r - 1, log) + combi(n - 1, r, log);
        }
    }
}
//8. 수열 추측하기
//설명
//
//가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터 차례대로 파스칼의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다.
//
//예를 들어 N이 4 이고 가장 윗 줄에 3 1 2 4 가 있다고 했을 때, 다음과 같은 삼각형이 그려진다.
//
//Image1.jpg
//
//N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.
//
//단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.
//
//
//입력
//첫째 줄에 두개의 정수 N(1≤N≤10)과 F가 주어진다.
//
//N은 가장 윗줄에 있는 숫자의 개수를 의미하며 F는 가장 밑에 줄에 있는 수로 1,000,000 이하이다.
//
//
//출력
//첫째 줄에 삼각형에서 가장 위에 들어갈 N개의 숫자를 빈 칸을 사이에 두고 출력한다.
//
//답이 존재하지 않는 경우는 입력으로 주어지지 않는다.
//
//
//예시 입력 1
//
//4 16
//예시 출력 1
//
//3 1 2 4