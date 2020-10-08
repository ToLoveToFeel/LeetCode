package _0367_Valid_Perfect_Square;

/**
 * Date: 2020/10/8 9:25
 * Content:
 * 二分查找
 * 注意点：两数相乘溢出问题
 * 解决方式：转为 int
 */
public class Solution {
    public boolean isPerfectSquare(int num) {

        int l = 1, r = num;  // 在[l...r]中寻找 num 的平方根
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            long square = (long) mid * (long) mid;
            if (num == square)
                return true;

            if (num > square)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).isPerfectSquare(1));
        System.out.println((new Solution()).isPerfectSquare(2));
        System.out.println((new Solution()).isPerfectSquare(81));
        System.out.println((new Solution()).isPerfectSquare(2147483647));
    }
}
