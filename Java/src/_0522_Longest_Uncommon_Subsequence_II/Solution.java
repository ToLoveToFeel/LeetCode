package _0522_Longest_Uncommon_Subsequence_II;

/**
 * Date: 2020/12/18 9:55
 * Content: 关键点：如果某个字符串的子序列为 最长特殊序列，则该字符串也是 最长特殊序列。可用反证法证明
 * 判断一个字符串是另一个字符串的子序列，可以用双指针解决，这是一个经典问题。
 * <p>
 * 执行用时：2 ms, 在所有 Java 提交中击败了52.40%的用户
 * 内存消耗：35.7 MB, 在所有 Java 提交中击败了88.96%的用户
 */
public class Solution {

    // 判断 a 是不是 b 的子序列
    private boolean check(String a, String b) {

        if (a.length() > b.length())
            return false;

        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == a.length();
    }

    public int findLUSlength(String[] strs) {

        int res = -1;

        for (int i = 0; i < strs.length; i++) {
            boolean isSub = false;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && check(strs[i], strs[j])) {
                    isSub = true;
                    break;
                }
            }
            if (!isSub) {
                res = Math.max(res, strs[i].length());
            }
        }

        return res;
    }

    public static void main(String[] args) {

//        String[] strs = {"aba", "cdc", "eae"};
        String[] strs = {"aaa", "aaa", "aa"};
        System.out.println((new Solution()).findLUSlength(strs));
    }
}
