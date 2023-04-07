package codingTestStudy;

import java.util.HashMap;
import java.util.Scanner;

public class ex04_04 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String S = in.nextLine();
        String T = in.nextLine();

        System.out.println(solution(S, T));
    }

    private static int solution(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int size = t.length;
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < size; i++) {
            map.put(s[i], map.getOrDefault(s[i], 0) + 1);
            tmap.put(t[i], tmap.getOrDefault(t[i], 0) + 1);
        }

        int cnt = 0;
        if (map.size() == tmap.size()) {
            for (char x : t) {
                if (map.getOrDefault(x, 0) == tmap.get(x)) cnt++;
            }
        }

        if (cnt == size) answer++;

        for (int i = size; i < s.length; i++) {
            cnt = 0;
            map.put(s[i], map.getOrDefault(s[i], 0) + 1);
            map.put(s[i - size], map.get(s[i - size]) - 1);
            if (map.get(s[i - size]) == 0) map.remove(s[i - size]);
            if (map.size() == tmap.size()) {
                for (char x : t) {
                    if (map.getOrDefault(x, 0) == tmap.get(x)) cnt++;
                }
            } else {
                continue;
            }
            if (cnt == size) answer++;
        }

        return answer;
    }
}
//4. 모든 아나그램 찾기
//설명
//S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
//아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
//
//입력
//첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
//S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
//
//출력
//S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
//
//예시 입력 1
//bacaAacba
//abc
//예시 출력 1
//3
//힌트
//출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다.

