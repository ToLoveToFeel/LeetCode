package _0093_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/9/13 19:48
 * Content: 回溯法
 */
public class Solution {

    List<String> res = new ArrayList<>();

    private String getString(ArrayList<Integer> ips) {
        StringBuilder sb = new StringBuilder();
        sb.append(ips.get(0));
        for (int i = 1; i < ips.size(); i++) {
            sb.append(".");
            sb.append(ips.get(i));
        }
        return sb.toString();
    }

    private void dfs(String s, int index, ArrayList<Integer> ips) {
        if (index == s.length()) {
            if (ips.size() == 4) res.add(getString(ips));
            return;
        }

        if (index == 0) {
            ips.add(s.charAt(0) - '0');
            dfs(s, index + 1, ips);
        } else {
            int next = ips.get(ips.size() - 1) * 10 + (s.charAt(index) - '0');
            if (next <= 255 && ips.get(ips.size() - 1) != 0) {  // 不能有前导0，有的话直接用.将前后分开
                ips.set(ips.size() - 1, next);
                dfs(s, index + 1, ips);
                ips.set(ips.size() - 1, next / 10);
            }
            if (ips.size() < 4) {  // 说明上一个数大于255，或者上一个数为0，则必须重新开始一个新的数据（如果数据的个数小于四个的话）
                ips.add(s.charAt(index) - '0');
                dfs(s, index + 1, ips);
                ips.remove(ips.size() - 1);
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {

        if (s.length() < 4 || s.length() > 12) return res;

        ArrayList<Integer> ips = new ArrayList<>();
        dfs(s, 0, ips);
        return res;
    }

    public static void main(String[] args) {
//        String s = "25525511135";
//        String s = "0000";
//        String s = "1111";
        String s = "101023";
        System.out.println((new Solution()).restoreIpAddresses(s));
    }
}
