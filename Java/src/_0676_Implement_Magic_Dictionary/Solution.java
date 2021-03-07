package _0676_Implement_Magic_Dictionary;

import java.util.Arrays;

/**
 * Created by WXX on 2021/3/7 19:18
 * 执行用时：88 ms, 在所有 Java 提交中击败了19.10%的用户
 * 内存消耗：46.5 MB, 在所有 Java 提交中击败了8.34%的用户
 */
public class Solution {

    static class MagicDictionary {

        public static final int N = 10010;

        int[][] son = new int[N][26];
        int idx;
        boolean[] isEnd = new boolean[N];

        public MagicDictionary() {
            for (int i = 0; i < N; i++) Arrays.fill(son[i], 0);
            idx = 0;
            Arrays.fill(isEnd, false);
        }

        private void insert(String s) {
            int p = 0;
            for (char c : s.toCharArray()) {
                int u = c - 'a';
                if (son[p][u] == 0) son[p][u] = ++idx;
                p = son[p][u];
            }
            isEnd[p] = true;
        }

        public void buildDict(String[] dictionary) {
            for (String s : dictionary) insert(s);
        }

        private boolean dfs(char[] s, int p, int u, int c) {
            if (isEnd[p] && c == 1 && u == s.length) return true;
            if (c > 1 || u == s.length) return false;

            for (int i = 0; i < 26; i++) {
                if (son[p][i] == 0) continue;
                if (dfs(s, son[p][i], u + 1, c + (s[u] - 'a' != i ? 1 : 0)))
                    return true;
            }
            return false;
        }

        public boolean search(String searchWord) {
            return dfs(searchWord.toCharArray(), 0, 0, 0);
        }
    }

    public static void main(String[] args) {

        MagicDictionary t = new MagicDictionary();
        t.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(t.search("hello"));  // false
        System.out.println(t.search("hhllo"));  // true
        System.out.println(t.search("hhll"));  // false
        System.out.println(t.search("leetcoded"));  // false
    }
}
