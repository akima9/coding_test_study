package leetCode.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex009 {
    public static void main(String[] args) {
//        System.out.println(findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        System.out.println(findKthPositive(new int[]{1, 2, 3, 4}, 2));
    }
    public static int findKthPositive(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int num = 1;
        int index = 0;
        while (index < k) {
            if (Arrays.binarySearch(arr, num) < 0) {
                list.add(num);
            }
            num++;
            index = list.size();
        }

        return list.get(index - 1);
    }
}
//Example 1:
//
//Input: arr = [2,3,4,7,11], k = 5
//Output: 9
//Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
//Example 2:
//
//Input: arr = [1,2,3,4], k = 2
//Output: 6
//Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.