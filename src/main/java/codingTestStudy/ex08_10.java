package codingTestStudy;

import java.util.Scanner;

public class ex08_10 {
    static int cnt = 0;
    static int[][] miro;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        miro = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                miro[i][j] = in.nextInt();
            }
        }

        DFS(0, 0);
        System.out.println(cnt);
    }

    public static void DFS(int L, int R) {
        if (L < 0 || R < 0 || L > 6 || R > 6) return;
        if (miro[L][R] == 1) return;
        if (L == 6 && R == 6) {
            cnt++;
            miro[L][R] = 0;
        } else {
            miro[L][R] = 1;
            DFS(L - 1, R);
            DFS(L, R + 1);
            DFS(L + 1, R);
            DFS(L, R - 1);
            miro[L][R] = 0;
        }
    }
}
//10. 미로탐색(DFS)
//설명
//
//7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.
//
//출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.
//
//격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
//
//Image1.jpg
//
//위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.
//
//
//입력
//7*7 격자판의 정보가 주어집니다.
//
//
//출력
//첫 번째 줄에 경로의 가지수를 출력한다.
//
//
//예시 입력 1
//
//0 0 0 0 0 0 0
//0 1 1 1 1 1 0
//0 0 0 1 0 0 0
//1 1 0 1 0 1 1
//1 1 0 0 0 0 1
//1 1 0 1 1 0 0
//1 0 0 0 0 0 0
//예시 출력 1
//
//8