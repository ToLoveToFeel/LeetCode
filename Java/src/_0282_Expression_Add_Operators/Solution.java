package _0282_Expression_Add_Operators;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2021/2/4 9:24
 * Content:
 * 执行用时：23 ms, 在所有 Java 提交中击败了93.95%的用户
 * 内存消耗：38.9 MB, 在所有 Java 提交中击败了87.19%的用户
 */
public class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> addOperators(String num, int target) {

        char[] path = new char[100];
        dfs(num, 0, 0, 0, 1, target, path);
        return ans;
    }

    private void dfs(String num, int u, int len, long a, long b, int target, char[] path) {
        if (u == num.length()) {
            if (a == target) ans.add(new String(path).substring(0, len - 1));
        } else {
            long c = 0;
            for (int i = u; i < num.length(); i++) {
                c = c * 10 + num.charAt(i) - '0';
                path[len++] = num.charAt(i);
                // +，只有加号才能考察最后一位，这样a就是最后的结果
                path[len] = '+';
                dfs(num, i + 1, len + 1, a + b * c, 1, target, path);
                if (i + 1 < num.length()) {  // i + 1代表不是最后一位
                    // -
                    path[len] = '-';
                    dfs(num, i + 1, len + 1, a + b * c, -1, target, path);

                    // *
                    path[len] = '*';
                    dfs(num, i + 1, len + 1, a, b * c, target, path);
                }
                if (num.charAt(u) == '0') break;  // 不能出现两个0
            }
        }
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).addOperators("123", 6));
    }
}
