package programmers;

public class ex31 {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    /**
     * 숫자의 합이 n이 되는 횟수를 구한다.
     * n이 15인 경우
     * => n이 어떤 수든 1번은 표현이 되기 때문에 answer는 최소 1이다.
     * 1 + 2 + 3 + 4 + 5 = 15 (O) answer = 2
     * 2 + 3 + 4 + 5 + 6 = 20 (X)
     * 3 + 4 + 5 + 6 = 18 (X)
     * 4 + 5 + 6 = 15 (O) answer = 3
     * 5 + 6 + 7 = 18 (X)
     * 6 + 7 + 8 = 21 (X)
     * 7 + 8 = 15 (O) answer = 4
     * => n / 2 까지만 반복한다. n / 2 보다 큰 수는 될 수가 없음.
     * 8 + 9 = 17 (X)
     * 9 + 10 = 19 (X)
     */
    public static int solution(int n) {
        int answer = 1;
        int half = n / 2;
        for (int i = 1; i <= half; i++) {
            int sum = 0;
            int startNum = i;
            while (sum < n) {
                sum += startNum;
                startNum++;
            }
            if (sum == n) answer++;
        }
        return answer;
    }
}
//숫자의 표현
//문제 설명
//Finn은 요즘 수학공부에 빠져 있습니다.
//수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다.
//예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.
//
//1 + 2 + 3 + 4 + 5 = 15
//4 + 5 + 6 = 15
//7 + 8 = 15
//15 = 15
//자연수 n이 매개변수로 주어질 때,
//연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.
//
//제한사항
//n은 10,000 이하의 자연수 입니다.
//입출력 예
//n	result
//15	4
//입출력 예 설명
//입출력 예#1
//문제의 예시와 같습니다.
//
//※ 공지 - 2022년 3월 11일 테스트케이스가 추가되었습니다.