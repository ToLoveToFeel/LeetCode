package _0273_Integer_to_English_Words;

/**
 * Date: 2021/2/3 11:11
 * Content:
 * 执行用时：3 ms, 在所有 Java 提交中击败了88.86%的用户
 * 内存消耗：36.7 MB, 在所有 Java 提交中击败了76.37%的用户
 */
public class Solution {

    String[] nums0_19 = {
            "Zero", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen",
    };
    String[] nums20_90 = {
            "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
            "Seventy", "Eighty", "Ninety"
    };
    String[] nums1000 = {
            "Billion ", "Million ", "Thousand ", ""
    };

    private String get(int x) {

        StringBuilder sb = new StringBuilder();
        if (x >= 100) {
            sb.append(nums0_19[x / 100]).append(" Hundred ");
            x %= 100;
        }
        if (x >= 20) {
            sb.append(nums20_90[x / 10 - 2]).append(' ');
            x %= 10;
        }
        if (x != 0) sb.append(nums0_19[x]).append(' ');
        return sb.toString();
    }

    public String numberToWords(int num) {

        if (num == 0) return "Zero";

        StringBuilder res = new StringBuilder();
        for (int i = (int)1e9, j = 0; i >= 1; i /= 1000, j++) {
            if (num >= i) {
                res.append(get(num / i)).append(nums1000[j]);
                num %= i;
            }
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).numberToWords(123));  // One Hundred Twenty Three
        System.out.println((new Solution()).numberToWords(1000));  // One Thousand
        System.out.println((new Solution()).numberToWords(1234));  // One Thousand One Hundred One
    }
}
