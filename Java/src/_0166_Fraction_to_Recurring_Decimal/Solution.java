package _0166_Fraction_to_Recurring_Decimal;

import java.util.HashMap;

/**
 * Date: 2021/1/24 11:19
 * Content:
 * 执行用时：9 ms, 在所有 Java 提交中击败了16.47%的用户
 * 内存消耗：37 MB, 在所有 Java 提交中击败了11.37%的用户
 */
public class Solution {

    public String fractionToDecimal(int numerator, int denominator) {

        long x = numerator, y = denominator;
        if (x % y == 0) return String.valueOf(x / y);

        StringBuilder sb = new StringBuilder();
        if ((x < 0) ^ (y < 0)) sb.append("-");
        x = Math.abs(x);
        y = Math.abs(y);
        sb.append(x / y).append(".");
        x %= y;
        HashMap<Long, Integer> hash = new HashMap<>();
        while (x != 0) {
            hash.put(x, sb.length());
            x *= 10;
            sb.append(x / y);
            x %= y;
            if (hash.containsKey(x)) {
                return sb.substring(0, hash.get(x)) + '(' + sb.substring(hash.get(x)) + ')';
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        // 0.(6)
        System.out.println((new Solution()).fractionToDecimal(2, 3));
        // 4.(3478260869565217391304)
        System.out.println((new Solution()).fractionToDecimal(100, 23));
    }
}
