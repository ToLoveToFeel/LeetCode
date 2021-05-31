package _0414_Third_Maximum_Number;

/**
 * Date: 2021/5/31 19:43
 * 执行用时：1 ms, 在所有 Java 提交中击败了92.34%的用户
 * 内存消耗：38.3 MB, 在所有 Java 提交中击败了55.59%的用户
 */
public class Solution {

    public int thirdMax(int[] nums) {
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE, s = 0;
        for (int x : nums) {
            if (x > a) {
                s++; c = b; b = a; a = x;
            } else if (x < a && x > b) {
                s++; c = b; b = x;
            } else if (x < b && x > c) {
                s++; c = x;
            }
        }
        if (s < 3) return (int) a;
        return (int) c;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).thirdMax(new int[]{1, 2, 3}));  // 1
    }
}
