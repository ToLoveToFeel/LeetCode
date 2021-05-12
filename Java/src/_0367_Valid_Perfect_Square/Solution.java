package _0367_Valid_Perfect_Square;

/**
 * Date: 2020/10/8 9:25
 * Content: 二分查找
 */
public class Solution {
    public boolean isPerfectSquare(int num) {

        int l = 1, r = num;  // 在[l...r]中寻找 num 的平方根
        while (l < r) {
            int mid = (r - l + 1) / 2 + l;
            if ((long) mid * mid <= num) l = mid;
            else r = mid - 1;
        }
        return l * l == num;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).isPerfectSquare(1));
        System.out.println((new Solution()).isPerfectSquare(2));
        System.out.println((new Solution()).isPerfectSquare(81));
        System.out.println((new Solution()).isPerfectSquare(2147483647));
    }
}
