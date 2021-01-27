package _0131_Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Date: 2021/1/27 11:00
 * Content:
 * 执行用时：24 ms, 在所有 Java 提交中击败了5.22%的用户
 * 内存消耗：58.6 MB, 在所有 Java 提交中击败了6.25%的用户
 */
public class Solution {

    boolean[][] f;
    List<List<String>> ans = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {

        int n = s.length();
        // 预处理：f[i][j]代表s[i...j]是否为回文串
        f = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++)
                if (i == j) f[i][j] = true;
                else if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 > j - 1 || f[i + 1][j - 1]) f[i][j] = true;
                }
        }

        dfs(s, 0);
        return ans;
    }

    private void dfs(String s, int u) {
        if (u == s.length()) ans.add((List<String>) path.clone());
        else {
            for (int i = u; i < s.length(); i++) {
                if (f[u][i]) {
                    path.add(s.substring(u, i + 1));
                    dfs(s, i + 1);
                    path.removeLast();
                }
            }
        }
    }

    public static void main(String[] args) {

        String s = "aab";
        System.out.println((new Solution()).partition(s));
    }
}
