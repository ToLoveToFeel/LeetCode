package _0000_study._leetcode._swordoffer._038_permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date: 2021/6/22 9:16
 */
public class Solution {

    List<String> ans = new ArrayList<>();
    boolean[] st;

    public String[] permutation(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        st = new boolean[n];
        Arrays.sort(cs);
        dfs(cs, 0, "");
        String[] res = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) res[i] = ans.get(i);
        return res;
    }

    private void dfs(char[] s, int cnt, String path) {
        if (cnt == s.length) {
            ans.add(path);
            return;
        }
        for (int i = 0; i < s.length; i++)
            if (!st[i]) {
                if (i > 0 && s[i] == s[i - 1] && !st[i - 1]) continue;
                st[i] = true;
                dfs(s, cnt + 1, path + s[i]);
                st[i] = false;
            }
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString((new Solution()).permutation("abc")));
        System.out.println(Arrays.toString((new Solution()).permutation("aab")));
    }
}
