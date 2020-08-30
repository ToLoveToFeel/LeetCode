package _0043_Multiply_Strings;

/**
 * Date: 2020/8/30 9:23
 * Content:
 */
class Solution2 {
    // 两个字符串相乘
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";

        int m = num1.length();
        int n = num2.length();
        int[] arr = new int[m + n];
        // 用数组存储各个值，最高位存储在arr[0]的位置
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n-1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                arr[i + j + 1] += x * y;
            }
        }
        // 处理进位
        for (int i = m + n -1; i > 0; i--) {
            arr[i - 1] += arr[i] / 10;
            arr[i] %= 10;
        }
        int index = (arr[0] == 0 ? 1 : 0);
        StringBuilder res = new StringBuilder();
        while (index < m + n) {
            res.append(arr[index ++]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println((new Solution2()).multiply("123", "456"));
    }
}
