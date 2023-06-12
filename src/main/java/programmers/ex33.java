package programmers;

public class ex33 {
    public static void main(String[] args) {
        System.out.println(solution(100000));
    }

    /**
     * 반복문으로 피보나치수를 구한다.
     * 모듈로 연산을 이용하면 int형으로 return 가능하다.
     * 사용된 모듈로 연산: (A + B) % C == ((A % C) + (B % C)) % C
     */
    public static int solution(int n) {
        int answer = 0;
        int[] F = new int[n + 1];
        F[0] = 0;
        F[1] = 1;

        for (int i = 2; i <= n; i++) {
            F[i] = (F[i - 1] % 1234567) + (F[i - 2] % 1234567);
        }
        answer = F[n] % 1234567;
        return answer;
    }
}
//피보나치 수
//문제 설명
//피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.
//
//예를들어
//
//F(2) = F(0) + F(1) = 0 + 1 = 1
//F(3) = F(1) + F(2) = 1 + 1 = 2
//F(4) = F(2) + F(3) = 1 + 2 = 3
//F(5) = F(3) + F(4) = 2 + 3 = 5
//와 같이 이어집니다.
//
//2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
//
//제한 사항
//n은 2 이상 100,000 이하인 자연수입니다.
//입출력 예
//n	return
//3	2
//5	5
//입출력 예 설명
//피보나치수는 0번째부터 0, 1, 1, 2, 3, 5, ... 와 같이 이어집니다.