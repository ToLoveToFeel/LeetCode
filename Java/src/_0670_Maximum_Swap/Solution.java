package _0670_Maximum_Swap;

/**
 * Created by WXX on 2021/3/4 14:20
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.2 MB, 在所有 Java 提交中击败了71.77%的用户
 */
public class Solution {
    public int maximumSwap(int num) {
        char[] str = String.valueOf(num).toCharArray();
        for (int i = 0; i + 1 < str.length; i++)
            if (str[i] < str[i + 1]) {
                int k = i + 1;
                for (int j = k; j < str.length; j++)
                    if (str[j] >= str[k])
                        k = j;
                for (int j = 0; ; j++)
                    if (str[j] < str[k]) {
                        char t = str[j]; str[j] = str[k]; str[k] = t;
                        return Integer.parseInt(String.valueOf(str));
                    }
            }
        return num;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).maximumSwap(2736));  // 7236
        System.out.println((new Solution()).maximumSwap(9973));  // 9973
        System.out.println((new Solution()).maximumSwap(1993));  // 9913
    }
}
