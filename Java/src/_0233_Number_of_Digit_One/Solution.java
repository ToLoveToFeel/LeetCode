package _0233_Number_of_Digit_One;

/**
 * Date: 2021/5/4 20:02
 */
public class Solution {

    public int countDigitOne(int n) {

        if (n <= 0) return 0;
        int[] nums = new int[10];
        int len = 0;
        while (n != 0) {
            nums[len++] = n % 10; n /= 10;
        }
        // 此时nums[0]对应最低位
        int res = 0;
        for (int i = 0; i < len; i++) {
            int d = nums[i];
            int left = 0, right = 0, p = 1;  // p存储10的次幂
            for (int j = len - 1; j > i; j--) left = left * 10 + nums[j];
            for (int j = i - 1; j >= 0; j--) {
                right = right * 10 + nums[j];
                p *= 10;
            }
            if (d == 0) res += left * p;
            else if (d == 1) res += left * p + right + 1;
            else res += (left + 1) * p;
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).countDigitOne(13));  // 6
    }
}
