package codingTestStudy;

import java.util.Scanner;

public class ex03_05 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println(solution(N));
    }

    private static int solution(int N) {
        int max = 0;
        if (N % 2 == 0) {
            max = N / 2;
        } else {
            max = N / 2 + 1;
        }

        int lt = 1, rt = 1, sum = 1, answer = 0;
        while (rt <= max) {
            if (sum < N) {
                rt++;
                sum += rt;
            } else if (sum == N) {
                answer++;
                rt++;
                sum += rt;
                sum -= lt;
                lt++;
            } else {
                sum -= lt;
                lt++;
            }
        }
        return answer;
    }
}
//5. 연속된 자연수의 합
//설명
//N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
//
//만약 N=15이면
//7+8=15
//4+5+6=15
//1+2+3+4+5=15
//와 같이 총 3가지의 경우가 존재한다.
//
//입력
//첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.
//
//출력
//첫 줄에 총 경우수를 출력합니다.
//
//예시 입력 1
//15
//예시 출력 1
//3