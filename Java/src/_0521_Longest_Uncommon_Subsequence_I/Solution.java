package _0521_Longest_Uncommon_Subsequence_I;

/**
 * Date: 2020/12/18 9:47
 * Content: 如果两个字符串相同的话，不存在最长特殊序列；如果不相等，最长特殊序列为那个长度较长的字符串
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.2 MB, 在所有 Java 提交中击败了70.52%的用户
 */
public class Solution {

    public int findLUSlength(String a, String b) {

        if (a.equals(b))
            return -1;

        return Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {

        String a = "aba";
        String b = "cdc";
        System.out.println((new Solution()).findLUSlength(a, b));  // 3
    }
}
