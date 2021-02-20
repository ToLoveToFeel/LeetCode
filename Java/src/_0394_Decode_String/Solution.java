package _0394_Decode_String;

/**
 * Date: 2021/2/20 10:27
 * Content: 递归回溯
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.3 MB, 在所有 Java 提交中击败了86.14%的用户
 */
public class Solution {

    public int u = 0;

    public String decodeString(String s) {

        return dfs(s.toCharArray());
    }

    private String dfs(char[] s) {

        StringBuilder res = new StringBuilder();
        while (u < s.length && s[u] != ']') {  // 这里s[u] != ']'是为了过滤掉最后一个右括号
            if ((s[u] >= 'a' && s[u] <= 'z') || (s[u] >= 'A' && s[u] <= 'Z')) res.append(s[u++]);
            else if (s[u] >= '0' && s[u] <= '9') {
                int k = u;
                while (s[k] >= '0' && s[k] <= '9') k++;
                int x = Integer.parseInt(new String(s, u, k - u));
                u = k + 1;  // 过滤掉左括号
                String y = dfs(s);
                u++;  // 过滤掉右括号
                while (x-- != 0) res.append(y);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).decodeString("3[a]"));  // aaa
        System.out.println((new Solution()).decodeString("3[a]2[bc]"));  // aaabcbc
        System.out.println((new Solution()).decodeString("3[a2[c]]"));  // accaccacc
    }
}
