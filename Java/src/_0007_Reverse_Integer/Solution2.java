package _0007_Reverse_Integer;


/**
 * Date: 2020/8/25 9:13
 * Content:
 * 时间复杂度：O(length(x))
 * 空间复杂度：O(1)
 */
public class Solution2 {

    public int reverse(int x) {

        int onetenthMax = Integer.MAX_VALUE / 10;
        int remainderOfMax = Integer.MAX_VALUE % 10;
        int onetenthMin = Integer.MIN_VALUE / 10;
        int remainderOfMin = Integer.MIN_VALUE % 10;

        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            if (res > onetenthMax || (res == onetenthMax && temp > remainderOfMax))
                return 0;
            if (res < onetenthMin || (res == onetenthMin && temp < remainderOfMin))
                return 0;
            res = res * 10 + temp;
            x = x / 10;
        }
        return res;
    }

    public static void main(String[] args) {

        int x = Integer.MAX_VALUE;
        System.out.println((new Solution2()).reverse(x));
    }
}
