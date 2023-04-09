package codingTestStudy;

import java.util.HashMap;
import java.util.Scanner;

public class ex05_02 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(solution(s));
    }

    private static String solution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char x : s.toCharArray()) {
            if (x == '(') map.put(x, map.getOrDefault(x, 0) + 1);
            if (x == ')') map.put('(', map.get('(') - 1);
            if (map.getOrDefault('(', 0) == 0 && x != ')') sb.append(x);
        }
        String answer = sb.toString();
        return answer;
    }
}
//2. 괄호문자제거
//설명
//입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
//
//입력
//첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
//
//출력
//남은 문자만 출력한다.
//
//예시 입력 1
//
//(A(BC)D)EF(G(H)(IJ)K)LM(N)
//예시 출력 1
//
//EFLM