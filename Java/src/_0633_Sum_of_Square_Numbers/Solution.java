package _0633_Sum_of_Square_Numbers;

/**
 * Date: 2021/4/28 9:14
 * 执行用时：4 ms, 在所有 Java 提交中击败了31.93%的用户
 * 内存消耗：35.4 MB, 在所有 Java 提交中击败了14.37%的用户
 */
public class Solution {

    public boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; i++) {
            int j = (int)Math.sqrt(c - i * i);
            if (i * i + j * j == c)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).judgeSquareSum(5));  // true
    }
}
