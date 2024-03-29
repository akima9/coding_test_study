package programmers;

import java.util.ArrayList;

public class ex60 {
    public static void main(String[] args) {
        System.out.println(solution(10, 10, 20, 20));
        System.out.println(solution(2, 4, 2, 1));
        System.out.println(solution(16, 16, 2, 1));
        System.out.println(solution(16, 16, 2, 2));
    }
    public static String solution(int n, int t, int m, int p) {
        //입력 형식
        //진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p 가 주어진다.

        //출력 형식
        //튜브가 말해야 하는 숫자 t개를 공백 없이 차례대로 나타낸 문자열. 단, 10~15는 각각 대문자 A~F로 출력한다.

        //입출력 예제
        //n	    t	m	p	result
        //2	    4	2	1	"0111"
        //16	16	2	1	"02468ACE11111111"
        //16	16	2	2	"13579BDF01234567"

        // n = 2
        // 0, 1, 10, 11, 100, ...
        // 0(튜브), 1, 1(튜브), 0, 1(튜브), 1, 1(튜브), 0, 0(튜브), ...
        // 0111...

        // n = 16
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F, 10, 11, 12, 14, 15, 16, 17, 18, 19, 1A, 1B, 1C, 1D, 1E, 1F, 20, ...
        // 0(튜브), 1, 2(튜브), 3, 4(튜브), 5, 6(튜브), 7, 8(튜브), 9, A(튜브), B, C(튜브), D, E(튜브), F, 1(튜브), 0, 1(튜브), 1, 1(튜브), 2, 1(튜브), 4, 1(튜브), 5, 1(튜브), 6, 1(튜브), 7, 1(튜브), 8, 1, 9, 1, A, 1, B, 1, C, 1, D, 1, E, 1, F, 2, 0, ...

        // 1. n진법으로 변환 -> 한글자씩 배열에 담는다.
        // 2. t의 m배 만큼 순환하면서, 문자열 생성
        ArrayList<String> strings = new ArrayList<>();
        for (long i = 0; i < t * m; i++) {
            String s = Long.toString(i, n);
            for (char c : s.toCharArray()) {
                strings.add(String.valueOf(c).toUpperCase());
            }
        }

        String answer = "";
        for (int i = p - 1; i < strings.size() && i < t * m; i += m) {
            answer += strings.get(i);
        }

        return answer;
    }
}
//[3차] n진수 게임
//문제 설명
//N진수 게임
//튜브가 활동하는 코딩 동아리에서는 전통적으로 해오는 게임이 있다.
//이 게임은 여러 사람이 둥글게 앉아서 숫자를 하나씩 차례대로 말하는 게임인데, 규칙은 다음과 같다.
//
//숫자를 0부터 시작해서 차례대로 말한다.
//첫 번째 사람은 0, 두 번째 사람은 1, … 열 번째 사람은 9를 말한다.
//10 이상의 숫자부터는 한 자리씩 끊어서 말한다.
//즉 열한 번째 사람은 10의 첫 자리인 1, 열두 번째 사람은 둘째 자리인 0을 말한다.
//이렇게 게임을 진행할 경우,
//0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 1, 1, 1, 2, 1, 3, 1, 4, …
//순으로 숫자를 말하면 된다.
//
//한편 코딩 동아리 일원들은 컴퓨터를 다루는 사람답게 이진수로 이 게임을 진행하기도 하는데, 이 경우에는
//0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, …
//순으로 숫자를 말하면 된다.
//
//이진수로 진행하는 게임에 익숙해져 질려가던 사람들은 좀 더 난이도를 높이기 위해 이진법에서 십육진법까지 모든 진법으로 게임을 진행해보기로 했다.
//숫자 게임이 익숙하지 않은 튜브는 게임에 져서 벌칙을 받는 굴욕을 피하기 위해, 자신이 말해야 하는 숫자를 스마트폰에 미리 출력해주는 프로그램을 만들려고 한다. 튜브의 프로그램을 구현하라.
//
//입력 형식
//진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p 가 주어진다.
//
//2 ≦ n ≦ 16
//0 ＜ t ≦ 1000
//2 ≦ m ≦ 100
//1 ≦ p ≦ m
//출력 형식
//튜브가 말해야 하는 숫자 t개를 공백 없이 차례대로 나타낸 문자열. 단, 10~15는 각각 대문자 A~F로 출력한다.
//
//입출력 예제
//n	t	m	p	result
//2	4	2	1	"0111"
//16	16	2	1	"02468ACE11111111"
//16	16	2	2	"13579BDF01234567"
//해설 보러가기