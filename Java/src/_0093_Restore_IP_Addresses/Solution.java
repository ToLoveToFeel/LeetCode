package _0093_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2021/4/26 17:20
 * Content: 回溯法
 */
public class Solution {

    List<String> ans = new ArrayList<>();

    private void dfs(char[] s, int u, int k, String path) {
        if (u == s.length) {
            if (k == 4) ans.add(path.substring(0, path.length() - 1));
            return;
        }

        if (k == 4) return;
        for (int i = u, t = 0; i < s.length; i++) {
            if (i > u && s[u] == '0') break;  // 说明有前导0
            t = t * 10 + s[i] - '0';
            if (t <= 255) dfs(s, i + 1, k + 1, path + t + ".");
            else break;
        }
    }

    public List<String> restoreIpAddresses(String s) {

        dfs(s.toCharArray(), 0, 0, "");
        return ans;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).restoreIpAddresses("25525511135"));
        System.out.println((new Solution()).restoreIpAddresses("0000"));
        System.out.println((new Solution()).restoreIpAddresses("1111"));
        System.out.println((new Solution()).restoreIpAddresses("101023"));
    }
}
