package leetCode;

import java.util.Arrays;

public class Ex44 {
    public static void main(String[] args) {
        System.out.println(maximizeSum(new int[]{5, 5, 5}, 2));
    }
    public static int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int m = nums[nums.length - 1];
        for (int i = 0; i < k; i++) {
            sum += m;
            m++;
        }

        return sum;
    }
}
