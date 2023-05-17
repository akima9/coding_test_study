package codingTestStudy;

import java.util.*;

public class ex08_05 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = in.nextInt();
        }
        int M = in.nextInt();

        System.out.println(solution(N, coins, M));
    }

    public static int solution(int N, int[] coins, int M) {
        LinkedList<Integer> Q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int cnt = 0;
        Q.offer(0);
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int cur = Q.poll();
                for (int k = 0; k < coins.length; k++) {
                    if (map.getOrDefault(cur + coins[k],0) == 0) {
                        if (cur == M) return cnt;
                        Q.offer(cur + coins[k]);
                        map.put(cur + coins[k], 1);
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }
}
//5. 동전교환
//설명
//
//다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
//
//각 단위의 동전은 무한정 쓸 수 있다.
//
//
//입력
//첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,
//
//그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.
//
//
//출력
//첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
//
//
//예시 입력 1
//
//3
//1 2 5
//15
//예시 출력 1
//
//3