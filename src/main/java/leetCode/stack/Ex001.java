package leetCode.stack;

import java.util.Stack;

public class Ex001 {
    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
    public static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String s : operations) {
            if (s.equals("C")) {
                stack.pop();
            } else if (s.equals("D")) {
                stack.add(stack.peek() * 2);
            } else if (s.equals("+")) {
                stack.add(stack.get(stack.size() - 2) + stack.get(stack.size() - 1));
            } else {
                stack.add(Integer.parseInt(s));
            }
        }

        int sum = 0;
        while (stack.size() > 0) {
            sum += stack.pop();
        }

        return sum;
    }
}
//Example 1:
//
//Input: ops = ["5","2","C","D","+"]
//Output: 30
//Explanation:
//        "5" - Add 5 to the record, record is now [5].
//        "2" - Add 2 to the record, record is now [5, 2].
//        "C" - Invalidate and remove the previous score, record is now [5].
//        "D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
//        "+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
//The total sum is 5 + 10 + 15 = 30.
//Example 2:
//
//Input: ops = ["5","-2","4","C","D","9","+","+"]
//Output: 27
//Explanation:
//        "5" - Add 5 to the record, record is now [5].
//        "-2" - Add -2 to the record, record is now [5, -2].
//        "4" - Add 4 to the record, record is now [5, -2, 4].
//        "C" - Invalidate and remove the previous score, record is now [5, -2].
//        "D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
//        "9" - Add 9 to the record, record is now [5, -2, -4, 9].
//        "+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
//        "+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
//The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.
//Example 3:
//
//Input: ops = ["1","C"]
//Output: 0
//Explanation:
//        "1" - Add 1 to the record, record is now [1].
//        "C" - Invalidate and remove the previous score, record is now [].
//Since the record is empty, the total sum is 0.