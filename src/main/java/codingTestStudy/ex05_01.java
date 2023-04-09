package codingTestStudy;

import java.util.HashMap;
import java.util.Scanner;

public class ex05_01 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(solution(s));
    }

    private static String solution(String s) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 && chars[i] == ')') return "NO";
            if (i == chars.length - 1 && chars[i] == '(') return "NO";
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        if (map.get('(') != map.get(')')) return "NO";
        return answer;
    }
}
//1. 올바른 괄호
//설명
//괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
//(())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
//
//입력
//첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
//
//출력
//첫 번째 줄에 YES, NO를 출력한다.
//
//예시 입력 1
//(()(()))(()
//예시 출력 1
//NO