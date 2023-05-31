package codingTestStudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Meeting implements Comparable<Meeting>{
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.end == o.end) {
            if (this.start > o.start) {
                return 1;
            } else if (this.start == o.start) {
                return 0;
            } else {
                return -1;
            }
        }
        if (this.end > o.end) { // 앞이 크면 양수
            return 1;
        } else if (this.end == o.end) { // 같으면 0
            return 0;
        } else { // 뒤가 크면 음수
            return -1;
        }
    }
}
public class ex09_02 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(in.nextInt(), in.nextInt()));
        }
        Collections.sort(meetings);
        System.out.println(solution(n, meetings));
    }

    public static int solution(int n, ArrayList<Meeting> meetings) {
        int cnt = 0;
        int endTime = 0;
        for (Meeting m : meetings) {
            if (endTime <= m.start) {
                cnt++;
                endTime = m.end;
            }
        }

        return cnt;
    }
}
//2. 회의실 배정
//설명
//
//한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.
//
//각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
//
//단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
//
//
//입력
//첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다. 둘째 줄부터 n+1 줄까지 각 회의의 정보가 주어지는데
//
//이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 회의시간은 0시부터 시작한다.
//
//회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.
//
//
//출력
//첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.
//
//
//예시 입력 1
//
//5
//1 4
//2 3
//3 5
//4 6
//5 7
//예시 출력 1
//
//3
//예시 입력 2
//
//3
//3 3
//1 3
//2 3
//예시 출력 2
//
//2