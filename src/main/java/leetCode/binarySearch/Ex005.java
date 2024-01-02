package leetCode.binarySearch;

public class Ex005 {
    public static void main(String[] args) {
        System.out.println(fairCandySwap(new int[]{2}, new int[]{1, 3}));
    }
    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aSum = 0, bSum = 0;

        for (int a : aliceSizes) {
            aSum += a;
        }

        for (int b : bobSizes) {
            bSum += b;
        }

        int aStart = 0;
        int aEnd = aliceSizes.length - 1;
        int aMid;

        int bStart = 0;
        int bEnd = bobSizes.length - 1;
        int bMid;

        int temp;

        while (aStart <= aEnd && bStart <= bEnd) {
            aMid = (aStart + aEnd) / 2;
            bMid = (bStart + bEnd) / 2;

            aSum = aSum - aliceSizes[aMid] + bobSizes[bMid];
            bSum = bSum - bobSizes[bMid] + aliceSizes[aMid];

            temp = aliceSizes[aMid];
            aliceSizes[aMid] = bobSizes[bMid];
            bobSizes[bMid] = temp;

            if (aSum < bSum) {
                aEnd = aMid;
                bStart = bMid + 1;
            } else if (aSum > bSum) {
                aEnd = aMid;
                bStart = bMid + 1;
            } else {
                System.out.println(aliceSizes[aMid]);
                System.out.println(bobSizes[bMid]);
                return new int[]{aliceSizes[aMid], bobSizes[bMid]};
            }
        }
        //1, 2, 6 => 9
        //2, 3, 4 => 9

        //1, 3, 6 => 10
        //2, 2, 4 => 8

        //2, 3, 6 => 11
        //1, 2, 4 => 7
        return null;
    }
}
//Example 1:
//
//Input: aliceSizes = [1,1], bobSizes = [2,2]
//Output: [1,2]
//Example 2:
//
//Input: aliceSizes = [1,2], bobSizes = [2,3]
//Output: [1,2]
//Example 3:
//
//Input: aliceSizes = [2], bobSizes = [1,3]
//Output: [2,3]