package _0258_Add_Digits;

/**
 * Date: 2020/11/29 14:39
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.6 MB, 在所有 Java 提交中击败了80.19%的用户
 */
public class Solution {

    public int addDigits(int num) {

        int res = num;
        while (res >= 10) {  // 新生成的数据不是一位数
            res = 0;
            while (num > 0) {
                res += (num % 10);
                num /= 10;
            }
            num = res;
        }

        return res;
    }

    public static void main(String[] args) {

        int num = 38;  // 2
        System.out.println((new Solution()).addDigits(num));
    }
}
