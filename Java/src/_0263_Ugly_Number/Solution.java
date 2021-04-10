package _0263_Ugly_Number;

/**
 * Date: 2021/2/1 14:49
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.2 MB, 在所有 Java 提交中击败了93.92%的用户
 */
public class Solution {

    public boolean isUgly(int num) {

        if (num <= 0) return false;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).isUgly(6));  // true
        System.out.println((new Solution()).isUgly(8));  // true
        System.out.println((new Solution()).isUgly(14));  // false
    }
}
