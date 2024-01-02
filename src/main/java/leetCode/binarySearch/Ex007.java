package leetCode.binarySearch;

import java.util.Arrays;

public class Ex007 {
    public static void main(String[] args) {
        System.out.println(getCommon(new int[]{1, 2, 3}, new int[]{2, 4}));
    }
    public static int getCommon(int[] nums1, int[] nums2) {
        int start = 0;
        int end = nums1.length - 1;
        int mid = 0;
        int min = Integer.MAX_VALUE;

        while (start <= end) {
            mid = (start + (end - start)) / 2;

            int index = Arrays.binarySearch(nums2, nums1[mid]);
            if (index > -1) {
                end = mid;
                min = Math.min(min, index);
            }
        }
        return -1;
    }
}
//Example 1:
//
//Input: nums1 = [1,2,3], nums2 = [2,4]
//Output: 2
//Explanation: The smallest element common to both arrays is 2, so we return 2.
//Example 2:
//
//Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
//Output: 2
//Explanation: There are two common elements in the array 2 and 3 out of which 2 is the smallest, so 2 is returned.