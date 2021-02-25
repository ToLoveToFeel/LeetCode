package _0326_Power_of_Three;

/**
 * Created by WXX on 2021/2/25 10:26
 * 执行用时：15 ms, 在所有 Java 提交中击败了99.49%的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了6.44%的用户
 */
public class Solution {

    public boolean isPowerOfThree(int n) {

        // int范围内最大的3的幂为：3^19 = 1162261467
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).isPowerOfThree(0));  // false
        System.out.println((new Solution()).isPowerOfThree(27));  // true
    }
}
