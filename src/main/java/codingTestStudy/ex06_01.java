package codingTestStudy;

import java.util.Scanner;

public class ex06_01 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] ints = new int[N];
        for (int i = 0; i < N; i++) {
            ints[i] = in.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        for (int x : solution(N, ints)) {
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static int[] solution(int N, int[] ints) {
        for (int i = 0; i < N; i++) {
            int min = ints[i];
            int minIndex = i;

            for (int j = i + 1; j < N; j++) {
                if (min > ints[j]) {
                    min = ints[j];
                    minIndex = j;
                }
            }

            if (i < minIndex) {
                int temp = ints[i];
                ints[i] = min;
                ints[minIndex] = temp;
            }
        }

        return ints;
    }
}
//1. 선택 정렬
//설명
//N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
//정렬하는 방법은 선택정렬입니다.
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
//13 5 11 7 23 15
//
//예시 출력 1
//5 7 11 13 15 23