package _0069_Sqrt_x;

/**
 * Date: 2020/9/10 15:16
 * Content:
 * 线性扫描
 * 时间复杂度：O(n)
 */
public class Solution {

    public int mySqrt(int x) {
        if (x <= 1) return x;  // x是非负的

        for (int i = 1; i < x; i++)
            if (i * i <= x && x < (long) (i + 1) * (i + 1))
                return i;

        return -1;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).mySqrt(9));
        System.out.println((new Solution()).mySqrt(2147395600));
    }
}
