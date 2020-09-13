package _0069_Sqrt_x;

/**
 * Date: 2020/9/10 15:16
 * Content:
 * 二分查找
 * 时间复杂度：O(n)
 */
public class Solution2 {
    public int mySqrt(int x) {
        int left = 0, right = x;  // 在[left...right]的范围内寻找平方根
        int res = -1;
        while (left <= right) {  // 当 left == right 时，区间[left...right]仍然是有效的
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
