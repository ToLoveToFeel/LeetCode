package _0069_Sqrt_x;

/**
 * Date: 2020/9/10 15:16
 * Content:
 * 二分查找
 * 时间复杂度：O(n)
 */
public class Solution2 {
    public int mySqrt(int x) {
        int left = 0, right = x;
        int res = -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((new Solution2()).mySqrt(7));
        System.out.println((new Solution2()).mySqrt(2147395600));
    }
}
