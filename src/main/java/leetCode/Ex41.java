package leetCode;

import java.util.Arrays;

public class Ex41 {
    public static void main(String[] args) {
        System.out.println(minimumSum(6466));
    }
    public static int minimumSum(int num) {
        String s = String.valueOf(num);
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return (Character.getNumericValue(charArray[0]) + Character.getNumericValue(charArray[1])) * 10 + Character.getNumericValue(charArray[2]) + Character.getNumericValue(charArray[3]);
    }
}