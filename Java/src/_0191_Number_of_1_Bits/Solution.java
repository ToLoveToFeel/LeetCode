package _0191_Number_of_1_Bits;

/**
 * Date: 2020/10/4 9:45
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了95.44%的用户
 * 内存消耗：35.4 MB, 在所有 Java 提交中击败了44.14%的用户
 */
public class Solution {

    public int hammingWeight(int n) {

        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n >> i & 1) == 1)
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).hammingWeight(13));  // 3
        System.out.println((new Solution()).hammingWeight(-3));  // 31
    }
}
