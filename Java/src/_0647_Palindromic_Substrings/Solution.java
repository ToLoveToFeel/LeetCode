package _0647_Palindromic_Substrings;

/**
 * Date: 2020/12/15 13:56
 * Content: 暴力解法即可，根据回文串的奇偶中心扩散
 * 由数据范围反推算法复杂度以及算法内容 : https://www.acwing.com/blog/content/32/
 * <p>
 * 执行用时：4 ms, 在所有 Java 提交中击败了80.50%的用户
 * 内存消耗：36.6 MB, 在所有 Java 提交中击败了81.53%的用户
 */
public class Solution {

    public int countSubstrings(String s) {

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            // 枚举长度为奇数的情况
            for (int j = i, k = i; j >= 0 && k < s.length(); j--, k++) {
                if (s.charAt(j) != s.charAt(k))
                    break;
                res++;
            }
            // 枚举长度为偶数的情况
            for (int j = i, k = i + 1; j >= 0 && k < s.length(); j--, k++) {
                if (s.charAt(j) != s.charAt(k))
                    break;
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).countSubstrings("abc"));  // 3
        System.out.println((new Solution()).countSubstrings("aaa"));  // 6
    }
}
