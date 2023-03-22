package codingTestStudy;

import java.util.Scanner;

public class ex02_02 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        String talls = in.nextLine();

        System.out.println(solution(N, talls));
    }

    private static int solution(int N, String talls) {
        String[] tallArr = talls.split(" ");

        int max = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(tallArr[i]);
            if (max < cur) {
                cnt++;
                max = cur;
            }
        }
        return cnt;
    }
}
//2. 보이는 학생
//설명
//선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
//선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
//
//입력
//첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.
//
//출력
//선생님이 볼 수 있는 최대학생수를 출력한다.
//
//예시 입력 1
//8
//130 135 148 140 145 150 150 153
//
//예시 출력 1
//5