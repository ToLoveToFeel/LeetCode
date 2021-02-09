package _0301_Remove_Invalid_Parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2021/2/9 10:32
 * Content:
 * 执行用时：8 ms, 在所有 Java 提交中击败了62.85%的用户
 * 内存消耗：38.8 MB, 在所有 Java 提交中击败了57.67%的用户
 */
public class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int l = 0;  // l：当前左括号数量减去右括号数量
        int r = 0;  // r：当前要删除多少右括号
        for (char c : s.toCharArray()) {
            if (c == '(') l++;
            else if (c == ')') {
                if (l == 0) r++;
                else l--;
            }
        }
        dfs(s.toCharArray(), 0, "", 0, l, r);
        return ans;
    }

    /**
     * @param s    考察的字符串
     * @param u    枚举到字符串的第几个字符
     * @param path 当前删完括号后剩余的字符串是什么
     * @param cnt  当前path中左括号减去右括号的数量
     * @param l    当前还可以删除多少左括号
     * @param r    当前还可以删除多少右括号
     */
    private void dfs(char[] s, int u, String path, int cnt, int l, int r) {
        if (u == s.length) {
            if (cnt == 0) ans.add(path);
            return;
        }
        if (s[u] != '(' && s[u] != ')') dfs(s, u + 1, path + s[u], cnt, l, r);
        else if (s[u] == '(') {
            int k = u;
            while (k < s.length && s[k] == '(') k++;
            l -= (k - u);
            for (int i = k - u; i >= 0; i--) {
                if (l >= 0) dfs(s, k, path, cnt, l, r);
                path += '(';
                l++;
                cnt++;
            }
        } else if (s[u] == ')') {
            int k = u;
            while (k < s.length && s[k] == ')') k++;
            r -= (k - u);
            for (int i = k - u; i >= 0; i--) {
                if (cnt >= 0 && r >= 0) dfs(s, k, path, cnt, l, r);
                path += ')';
                r++;
                cnt--;
            }
        }
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).removeInvalidParentheses("()())()"));  // [(())(), ()()()]
        System.out.println((new Solution()).removeInvalidParentheses("(a)())()"));  // [(a())(), (a)()()]
        System.out.println((new Solution()).removeInvalidParentheses(")("));  // []
    }
}
