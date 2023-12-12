package leetCode.binarySearch;

public class Ex006 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{5}, 5));
    }
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
//Example 1:
//
//Input: nums = [-1,0,3,5,9,12], target = 9
//Output: 4
//Explanation: 9 exists in nums and its index is 4
//Example 2:
//
//Input: nums = [-1,0,3,5,9,12], target = 2
//Output: -1
//Explanation: 2 does not exist in nums so return -1
