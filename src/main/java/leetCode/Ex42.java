package leetCode;

import java.util.Collections;
import java.util.Stack;

public class Ex42 {
    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
    }
    public static int balancedStringSplit(String s) {
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        int isFirst = 0;
        char pushChar = 'R';
        char popChar = 'L';
        for (char c : s.toCharArray()) {
            if (stack.empty()) isFirst = 0;
            if (isFirst == 0) {
                pushChar = c;
                if (pushChar == 'R') {
                    popChar = 'L';
                } else {
                    popChar = 'R';
                }
            }
            isFirst = 1;
            if (c == pushChar) {
                stack.push(c);
            } else if (c == popChar) {
                stack.pop();
            }
            if (stack.empty()) cnt++;
        }
        return cnt;
    }
}