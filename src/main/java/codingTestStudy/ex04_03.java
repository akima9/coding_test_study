package codingTestStudy;

import java.util.HashMap;
import java.util.Scanner;

public class ex04_03 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int[] sales = new int[N];
        for (int i = 0; i < N; i++) {
            sales[i] = in.nextInt();
        }

        System.out.println(solution(N, K, sales));

    }

    private static String solution(int N, int K, int[] sales) {
        String answer = "";
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < K; i++) {
            map.put(sales[i], map.getOrDefault(sales[i], 0) + 1);
        }
        answer += map.size();

        for (int i = K; i < N; i++) {
            map.put(sales[i], map.getOrDefault(sales[i], 0) + 1);
            if (map.containsKey(sales[i - K])) {
                if (map.get(sales[i - K]) == 1) {
                    map.remove(sales[i - K]);
                } else {
                    map.put(sales[i - K], map.get(sales[i - K]) - 1);
                }
            }
            answer += " " + map.size();
        }
        return answer;
    }
}
//3. 매출액의 종류
//설명
//현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
//각 구간별로 구하라고 했습니다.
//
//만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
//20 12 20 10 23 17 10
//
//각 연속 4일간의 구간의 매출종류는
//첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
//두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
//세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
//네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
//
//N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
//매출액의 종류를 출력하는 프로그램을 작성하세요.
//
//입력
//첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
//두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
//
//출력
//첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.
//
//예시 입력 1
//7 4
//20 12 20 10 23 17 10
//
//예시 출력 1
//3 4 4 3