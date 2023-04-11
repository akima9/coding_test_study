package codingTestStudy;

import java.util.Scanner;

public class ex06_03 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = in.nextInt();
        }

        solution(N, a);

        StringBuilder sb = new StringBuilder();

        for (int x : a) {
            sb.append(x).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static void solution(int N, int[] a) {
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (a[j - 1] > a[j]) {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
//3. 삽입 정렬
//설명
//N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
//정렬하는 방법은 삽입정렬입니다.
//
//입력
//첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
//두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.
//
//출력
//오름차순으로 정렬된 수열을 출력합니다.
//
//예시 입력 1
//6
//11 7 5 6 10 9
//
//예시 출력 1
//5 6 7 9 10 11