package _0191_Number_of_1_Bits;

/**
 * Date: 2020/10/4 9:45
 * Content:
 */
public class Solution {
    private static final int MASK = 1;

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & MASK) == 1)
                res++;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).hammingWeight(13));
        System.out.println((new Solution()).hammingWeight(-3));
    }
}
