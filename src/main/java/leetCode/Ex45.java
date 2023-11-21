package leetCode;

import java.util.Arrays;

public class Ex45 {
    public static void main(String[] args) {
        System.out.println(largestSumAfterKNegations(new int[]{2,-3,-1,5,-4}, 2));
    }
    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            nums[0] = nums[0] * -1;
            Arrays.sort(nums);
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum;
    }
}
