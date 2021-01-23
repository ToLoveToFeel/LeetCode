package _0029_Divide_Two_Integers;

/**
 * Date: 2020/10/16 15:46
 * Content:
 * 超出时间限制
 */
public class Solution {

    // 返回正整数除法 a / b , 并且 a 和 b 均不为 0
    private int positiveDivide(int a, int b) {
        int count = -1;
        int sum = 0;
        while (sum <= a) {
            sum += b;
            count++;
        }

        return count;
    }

    public int divide(int a, int b) {

        // 特殊情况处理
        if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
        if (b == 1) return a;
        if (b == -1) return -a;
        if (a == 0) return 0;

        int sign = ((a ^ b) >>> 31);  // 结果为 1 的话，说明异号；结果为 0 的话，说明同号；

        return sign == 1 ?
                -positiveDivide(Math.abs(a), Math.abs(b)) :
                positiveDivide(Math.abs(a), Math.abs(b));
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).divide(10, 3));
        System.out.println((new Solution()).divide(7, -3));
    }
}
