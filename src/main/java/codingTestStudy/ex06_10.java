package codingTestStudy;

import java.util.Arrays;
import java.util.Scanner;

public class ex06_10 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] points = new int[N];
        for (int i = 0; i < N; i++) {
            points[i] = in.nextInt();
        }
        System.out.println(solution(N, M, points));
    }

    /**
     * 가장 가까운 두 말의 최대 거리를 반환한다.
     * @param N 마구간의 수
     * @param M 말의 수
     * @param points 마구간 좌표
     * @return 가장 가까운 두 말의 최대 거리
     */
    private static int solution(int N, int M, int[] points) {
        int result = 0;

        // 마구간 좌표 오름차순 정렬
        Arrays.sort(points);
        // 두 말 사이의 거리 중 최소가 될 수 있는 값
        int min = 1;
        // 두 말 사이의 거리 중 최대가 될 수 있는 값
        int max = points[N - 1] - 1;
        // min ~ max 범위를 이분 탐색
        while (min <= max) {
            // min ~ max의 중간 값
            int mid = (min + max) / 2;
            // 이전 말의 위치
            int prev = 0;
            // 말의 수
            int horseCnt = 1;
            for (int i = 0; i < N; i++) {
                if (i == 0) {
                    prev = points[i];
                } else {
                    // 이전 말의 좌표와 현재 말의 좌표 사이의 거리가 mid 보다 크거나 같은 경우
                    if (points[i] - prev >= mid) {
                        prev = points[i];
                        horseCnt++;
                    }
                }
            }

            if (horseCnt >= M) {
                min = mid + 1;
                result = mid;
            } else {
                max = mid - 1;
            }
        }
        return result;
    }
}
//10. 마구간 정하기(결정알고리즘)
//설명
//N개의 마구간이 수직선상에 있습니다.
//각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.
//현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,
//가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
//C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.
//
//입력
//첫 줄에 자연수 N(3<=N<=200,000)과 C(2<=C<=N)이 공백을 사이에 두고 주어집니다.
//둘째 줄에 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 차례로 주어집니다.
//
//출력
//첫 줄에 가장 가까운 두 말의 최대 거리를 출력하세요.
//
//예시 입력 1
//5 3
//1 2 8 4 9
//
//예시 출력 1
//3