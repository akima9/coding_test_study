package leetCode.stack;

import java.util.Stack;

public class Ex002 {
    public static void main(String[] args) {
        System.out.println(isValid(")"));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (stack.size() > 0 && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == '}') {
                if (stack.size() > 0 && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == ']') {
                if (stack.size() > 0 && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.add(c);
            }
        }

        return stack.isEmpty();
    }
}
//Example 1:
//
//Input: s = "()"
//Output: true
//Example 2:
//
//Input: s = "()[]{}"
//Output: true
//Example 3:
//
//Input: s = "(]"
//Output: false