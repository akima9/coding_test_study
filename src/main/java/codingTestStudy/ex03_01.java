package codingTestStudy;

import java.util.ArrayList;
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

        for (int e : solution(N, A, M, B)) {
            System.out.print(e + " ");
        }
    }

    private static ArrayList<Integer> solution(int N, int[] A, int M, int[] B) {
        int pA = 0;
        int pB = 0;
        ArrayList<Integer> total = new ArrayList<>();

        while (pA < N && pB < M) {
            if (A[pA] < B[pB]) {
                total.add(A[pA]);
                pA++;
            } else {
                total.add(B[pB]);
                pB++;
            }
        }

        while (pA < N) {
            total.add(A[pA]);
            pA++;
        }

        while (pB < M) {
            total.add(B[pB]);
            pB++;
        }

        return total;
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