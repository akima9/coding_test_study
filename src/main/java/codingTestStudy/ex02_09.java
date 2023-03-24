package codingTestStudy;

import java.util.Scanner;

public class ex02_09 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] a = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = in.nextInt();
            }
        }
        System.out.println(solution(N, a));
    }

    private static int solution(int N, int[][] a) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += a[i][j];
            }
            max = Math.max(max, sum);
        }

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += a[j][i];
            }
            max = Math.max(max, sum);
        }

        int tempSumA = 0;
        for (int i = 0; i < N; i++) {
            tempSumA += a[i][i];
        }
        max = Math.max(max, tempSumA);

        tempSumA = 0;
        for (int i = N - 1; i >= 0; i--) {
            tempSumA += a[i][i];
        }
        max = Math.max(max, tempSumA);
        return max;
    }
}
//9. 격자판 최대합
//설명
//5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
//N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
//
//입력
//첫 줄에 자연수 N이 주어진다.(2<=N<=50)
//두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
//
//출력
//최대합을 출력합니다.
//
//예시 입력 1
//5
//10 13 10 12 15
//12 39 30 23 11
//11 25 50 53 15
//19 27 29 37 27
//19 13 30 13 19
//
//예시 출력 1
//155
