package leetCode.binarySearch;

public class Ex008 {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(5));
    }
    public static boolean isPerfectSquare(int num) {
        int low = 1;
        int heigh = num;
        if(num==1) return true;

        while(low<=heigh)
        {
            int mid = low + (heigh-low)/2;
            int val = (num)/(mid);
            if(mid<val) low = mid + 1;
            else if(mid>val) heigh = mid-1;
            else return true;
        }
        return false;
    }
}
//Example 1:
//
//Input: num = 16
//Output: true
//Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
//        Example 2:
//
//Input: num = 14
//Output: false
//Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.
