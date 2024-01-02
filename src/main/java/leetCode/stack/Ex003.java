package leetCode.stack;

import java.util.Stack;

public class Ex003 {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("a##c", "#a#c"));
    }
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (stackS.size() > 0) {
                    stackS.pop();
                }
            } else {
                stackS.add(c);
            }
        }

        String S = "";
        for (char c : stackS) {
            S += c;
        }

        Stack<Character> stackT = new Stack<>();
        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (stackT.size() > 0) {
                    stackT.pop();
                }
            } else {
                stackT.add(c);
            }
        }

        String T = "";
        for (char c : stackT) {
            T += c;
        }

        return S.equals(T);
    }
}
//Example 1:
//
//Input: s = "ab#c", t = "ad#c"
//Output: true
//Explanation: Both s and t become "ac".
//Example 2:
//
//Input: s = "ab##", t = "c#d#"
//Output: true
//Explanation: Both s and t become "".
//Example 3:
//
//Input: s = "a#c", t = "b"
//Output: false
//Explanation: s becomes "c" while t becomes "b".