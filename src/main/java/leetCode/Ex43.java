package leetCode;

import java.util.Arrays;

public class Ex43 {
    public static void main(String[] args) {
        System.out.println(maximum69Number(9669));
    }
    public static int maximum69Number(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        boolean flag = true;
        String str = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '6' && flag) {
                chars[i] = '9';
                flag = false;
            }
            str += chars[i];
        }
        return Integer.parseInt(str);
    }
}
