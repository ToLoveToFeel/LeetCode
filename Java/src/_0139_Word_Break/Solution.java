package _0139_Word_Break;

import _0000_study._common.Build;

import java.util.HashSet;
import java.util.List;

/**
 * Date: 2021/1/29 16:42
 * Content: 字符串哈希、动态规划
 * 执行用时：7 ms, 在所有 Java 提交中击败了71.39%的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了59.76%的用户
 */
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        char[] cs = (" " + s).toCharArray();
        // 字符串哈希
        int P = 131;
        HashSet<Long> hash = new HashSet<>();
        for (String word : wordDict) {
            long h = 0;
            for (int i = 0; i < word.length(); i++) h = h * P + word.charAt(i);
            hash.add(h);
        }

        // 动态规划
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 0; i < n; i++) {
            if (f[i]) {
                long h = 0;
                for (int j = i + 1; j <= n; j++) {
                    h = h * P + cs[j];
                    if (hash.contains(h)) f[j] = true;
                }
            }
        }
        return f[n];
    }

    public static void main(String[] args) {

        String s = "applepenapple";
        String[] t = {"apple", "pen"};
        List<String> wordDict = Build.build(t);
        System.out.println((new Solution()).wordBreak(s, wordDict));  // true
    }
}
