package codingTestStudy;

import java.util.Arrays;
import java.util.Scanner;

public class ex03_01 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = in.nextInt();
        }

        int M = in.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = in.nextInt();
        }

        System.out.println(solution(N, A, M, B));

    }

    private static String solution(int N, int[] A, int M, int[] B) {
        int[] total = new int[N + M]; // A와 B 배열의 크기 합만큼의 int 배열 생성

        // A 배열을 total 배열에 담는다.
        for (int i = 0; i < N; i++) {
            total[i] = A[i];
        }

        // B 배열을 total 배열에 담는다.
        // 인덱스 번호는 A 배열을 담았기 때문에 total[N] 부터 담는다.
        for (int i = 0; i < M; i++) {
            total[N + i]= B[i];
        }

        // total 배열 오름차순 정렬
        Arrays.sort(total);

        // 필요 없는 문자들을 제거한다.
        String answer = Arrays.toString(total)
                .replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .replaceAll(",", "");

        return answer;
    }
}
//1. 두 배열 합치기
//설명
//오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
//
//입력
//첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
//두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
//세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
//네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
//각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
//
//출력
//오름차순으로 정렬된 배열을 출력합니다.
//
//예시 입력 1
//3
//1 3 5
//5
//2 3 6 7 9
//예시 출력 1
//
//1 2 3 3 5 6 7 9