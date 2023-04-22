package codingTestStudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ex06_08 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            integers.add(in.nextInt());
        }
        System.out.println(solution(M, integers));
    }

    private static int solution(int M, ArrayList<Integer> integers) {
        Collections.sort(integers);

        // 이분검색
        int answer = 0;
        int lt = 0;
        int rt = integers.size() - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (integers.get(mid) == M) {
                answer = mid + 1;
                break;
            } else if (integers.get(mid) > M) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }
}
//8. 이분검색
//설명
//임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
//이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.
//
//입력
//첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.
//두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.
//
//출력
//첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.
//
//예시 입력 1
//8 32
//23 87 65 12 57 32 99 81
//
//예시 출력 1
//3