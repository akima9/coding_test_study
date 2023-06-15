package programmers;

public class ex41 {
    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(solution(3));
    }

    /**
     * 경우의 수가 피보나치 수가 된다
     *
     * n = 1 => answer = 1
     * n = 2 => answer = 2
     * n = 3 => answer = 3
     * n = 4 => answer = 5
     * n = 5 => answer = 8
     *
     * n = 1
     * 1
     * answer = 1
     *
     * n = 2
     * 1 1
     * 2
     * answer = 2
     *
     * n = 3
     * 1 1 1
     * 1 2
     * 2 1
     * answer = 3
     *
     * n = 4
     * 1 1 1 1
     * 1 1 2
     * 1 2 1
     * 2 1 1
     * 2 2
     * answer = 5
     *
     * n = 5
     * 1 1 1 1 1
     * 1 1 1 2
     * 1 1 2 1
     * 1 2 1 1
     * 2 1 1 1
     * 2 1 2
     * 2 2 1
     * 1 2 2
     * answer = 8
     */
    public static long solution(int n) {
        long answer = 0;
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 2] % 1234567 + f[i - 1] % 1234567;
        }
        answer = f[n] % 1234567;
        return answer;
    }
}
//멀리 뛰기
//문제 설명
//효진이는 멀리 뛰기를 연습하고 있습니다.
//효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다.
// 칸이 총 4개 있을 때, 효진이는
//(1칸, 1칸, 1칸, 1칸)
//(1칸, 2칸, 1칸)
//(1칸, 1칸, 2칸)
//(2칸, 1칸, 1칸)
//(2칸, 2칸)
//의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다.
//멀리뛰기에 사용될 칸의 수 n이 주어질 때,
//효진이가 끝에 도달하는 방법이 몇 가지인지 알아내,
//여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요.
//예를 들어 4가 입력된다면, 5를 return하면 됩니다.
//
//제한 사항
//n은 1 이상, 2000 이하인 정수입니다.
//입출력 예
//n	result
//4	5
//3	3
//입출력 예 설명
//입출력 예 #1
//위에서 설명한 내용과 같습니다.
//
//입출력 예 #2
//(2칸, 1칸)
//(1칸, 2칸)
//(1칸, 1칸, 1칸)
//총 3가지 방법으로 멀리 뛸 수 있습니다.