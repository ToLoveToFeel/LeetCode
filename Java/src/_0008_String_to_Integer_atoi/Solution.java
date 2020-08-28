package _0008_String_to_Integer_atoi;

/**
 * Date: 2020/8/28 10:21
 * Content:
 */
public class Solution {
    private boolean isDigit(char c) {
        if (c >= '0' && c <= '9')
            return true;
        return false;
    }

    public int myAtoi(String str) {
        if (str.trim().equals(""))
            return 0;
        int i = 0;
        // 过滤掉空格
        while (str.charAt(i) == ' ') {
            i++;
        }

        int sign = (str.charAt(i) == '-' ? -1 : 1);
        int res = 0;
        if (str.charAt(i) == '+' || str.charAt(i) == '-')
            i++;
        while (i < str.length() && isDigit(str.charAt(i))) {
            int r = str.charAt(i) - '0';
            int temp = sign * res;
            if (temp > Integer.MAX_VALUE / 10 || (temp == Integer.MAX_VALUE / 10 && r > Integer.MAX_VALUE % 10))
                return Integer.MAX_VALUE;
            if (temp < Integer.MIN_VALUE / 10 || (temp == Integer.MIN_VALUE / 10 && -r < Integer.MIN_VALUE % 10))
                return Integer.MIN_VALUE;
            res = res * 10 + r;
            i++;
        }
        return sign == 1 ? res : -res;
    }

    public static void main(String[] args) {
        String str = "2147483648";
        System.out.println((new Solution()).myAtoi(str));
    }
}
