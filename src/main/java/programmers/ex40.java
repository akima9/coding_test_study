package programmers;

public class ex40 {
    static int g;
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,6,8,14}));
    }

    /**
     * 2개의 수의 최소 공배수를 구하는 공식: a * b / 최대공약수
     * 2개의 수의 최대 공약수를 구하는 알고리즘: 유클리드 호제법
     *
     * 유클리드 호제법
     * a % b = r
     * a, b의 최대 공약수 == r, b의 최대 공약수
     *
     * 60, 46
     * 60 % 46 = 14
     * 46 % 14 = 4
     * 14 % 4 = 2
     * 4 % 2 = 0 //최대 공약수: 2
     */
    public static int solution(int[] arr) {
        gcm(arr[0], arr[1]);

        int l = arr[0] * arr[1] / g;
        for (int i = 2; i < arr.length; i++) {
            gcm(arr[i], l);
            l = arr[i] * l / g;
        }

        return l;
    }
    public static void gcm(int a, int b) {
        if (a % b == 0) {
            g = b;
            return;
        }
        gcm(b, a % b);
    }
}
//N개의 최소공배수
//문제 설명
//두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
//예를 들어 2와 7의 최소공배수는 14가 됩니다.
//정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
//n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
//
//제한 사항
//arr은 길이 1이상, 15이하인 배열입니다.
//arr의 원소는 100 이하인 자연수입니다.
//입출력 예
//arr	result
//[2,6,8,14]	168
//[1,2,3]	6