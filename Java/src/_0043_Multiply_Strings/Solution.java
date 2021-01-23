package _0043_Multiply_Strings;

/**
 * Date: 2020/8/30 9:23
 * Content:
 */
class Solution {

    // 两个字符串相加
    private String add(String num1, String num2) {

        int p = num1.length() - 1;
        int q = num2.length() - 1;

        StringBuilder res = new StringBuilder();
        int temp = 0;
        while (p >= 0 || q >= 0) {
            int x = (p >= 0 ? (num1.charAt(p) - '0') : 0);
            int y = (q >= 0 ? (num2.charAt(q) - '0') : 0);
            int t = x + y + temp;
            res.append((t) % 10);
            temp = (t) / 10;
            p--;
            q--;
        }
        if (temp != 0) res.append(temp);

        return res.reverse().toString();
    }

    // 一个字符串和一个数字字符相乘
    public String multiply(String num1, char ch) {
        if (ch == '0') return "0";
        else if (ch == '1') return num1;
        else {
            int x = ch - '0';
            int p = num1.length() - 1;

            StringBuilder res = new StringBuilder();
            int temp = 0;
            while (p >= 0) {
                int y = num1.charAt(p) - '0';
                int t = x * y + temp;
                res.append((t) % 10);
                temp = (t) / 10;
                p--;
            }
            if (temp != 0) res.append(temp);
            return res.reverse().toString();
        }
    }

    // 两个字符串相乘
    public String multiply(String num1, String num2) {

        String smallNum = (num1.length() < num2.length() ? num1 : num2);
        String largeNum = (num1.length() < num2.length() ? num2 : num1);
        StringBuilder suffix = new StringBuilder();
        String res = "0";
        for (int i = smallNum.length() - 1; i >= 0; i--) {
            String mul = multiply(largeNum, smallNum.charAt(i)) + suffix;
            res = add(mul, res);
            suffix.append('0');
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).multiply("123", "456"));  // 56088
    }
}
