package codingTestStudy;

import java.util.Arrays;
import java.util.Scanner;

public class ex01_10 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strSplit = str.split(" ");
        String s = strSplit[0];
        String t = strSplit[1];

        System.out.println(solution(s, t));
    }

    private static String solution(String s, String t) {
        int length = s.length();
        int[] answer = new int[length];

        int max = 101;
        for (int i = 0; i < length; i++) {
            if (String.valueOf(s.charAt(i)).equals(t)) {
                max = 0;
            } else {
                max++;
            }
            answer[i] = max;
        }

        max = 101;
        for (int i = length - 1; i >= 0; i--) {
            if (String.valueOf(s.charAt(i)).equals(t)) {
                max = 0;
            } else {
                max++;
                answer[i] = Math.min(answer[i], max);
            }
        }
        String result = Arrays.toString(answer).replaceAll("[^0-9 ]", "");
        return result;
    }
}
//10. 가장 짧은 문자거리
//설명
//한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
//
//입력
//첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
//문자열의 길이는 100을 넘지 않는다.
//
//출력
//첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
//
//예시 입력 1
//teachermode e
//예시 출력 1
//1 0 1 2 1 0 1 2 2 1 0