package _0012_Integer_to_Roman;

/**
 * Date: 2020/8/28 16:46
 * Content:
 */
class Solution3 {

    // 贪心算法
    public String intToRoman(int num) {

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        int num = 1994;
        System.out.println((new Solution3()).intToRoman(num));
    }
}
