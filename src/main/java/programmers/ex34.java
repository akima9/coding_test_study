package programmers;

import java.util.Stack;

public class ex34 {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }

    /**
     * stack에 한 글자씩 쌓는다.
     * 가장 마지막에 쌓은 글자를 확인해서 쌓으려는 글자와 같으면 pop, 다르면 push
     */
    public static int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (stack.peek() == s.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        if (stack.isEmpty()) answer = 1;
        return answer;
    }
}
//짝지어 제거하기
//문제 설명
//짝지어 제거하기는, 알파벳 소문자로 이루어진 문자열을 가지고 시작합니다.
//먼저 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾습니다.
//그다음, 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어 붙입니다.
//이 과정을 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료됩니다.
//문자열 S가 주어졌을 때, 짝지어 제거하기를 성공적으로 수행할 수 있는지 반환하는 함수를 완성해 주세요.
//성공적으로 수행할 수 있으면 1을, 아닐 경우 0을 리턴해주면 됩니다.
//
//예를 들어, 문자열 S = baabaa 라면
//
//b aa baa → bb aa → aa →
//
//의 순서로 문자열을 모두 제거할 수 있으므로 1을 반환합니다.
//
//제한사항
//문자열의 길이 : 1,000,000이하의 자연수
//문자열은 모두 소문자로 이루어져 있습니다.
//입출력 예
//s	result
//baabaa	1
//cdcd	0
//입출력 예 설명
//입출력 예 #1
//위의 예시와 같습니다.
//입출력 예 #2
//문자열이 남아있지만 짝지어 제거할 수 있는 문자열이 더 이상 존재하지 않기 때문에 0을 반환합니다.
//
//※ 공지 - 2020년 6월 8일 테스트케이스가 추가되었습니다.