package codingTestStudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture> {
    int M;
    int D;
    public Lecture(int m, int d) {
        M = m;
        D = d;
    }
    @Override
    public int compareTo(Lecture o) {
        if (this.D > o.D) {
            return -1;
        } else if (this.D < o.D) {
            return 1;
        }
        return 0;
    }
}
public class ex09_04 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            lectures.add(new Lecture(in.nextInt(), in.nextInt()));
        }

        System.out.println(solution(lectures));
    }

    private static int solution(ArrayList<Lecture> lectures) {
        Collections.sort(lectures);
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        int maxD = lectures.get(0).D;
        for (int i = maxD; i > 0; i--) {
            for (Lecture l: lectures) {
                if (l.D > i) continue;
                if (l.D < i) break;
                pQ.offer(l.M);
            }
            if (!pQ.isEmpty()) answer += pQ.poll();
        }
        return answer;
    }
}
//4. 최대 수입 스케쥴(PriorityQueue 응용문제)
//설명
//
//현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.
//
//각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
//
//단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
//
//
//입력
//첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.
//
//
//출력
//첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.
//
//
//예시 입력 1
//
//6
//50 2
//20 1
//40 2
//60 3
//30 3
//30 1
//예시 출력 1
//
//150