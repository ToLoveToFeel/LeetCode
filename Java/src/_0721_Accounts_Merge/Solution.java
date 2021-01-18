package _0721_Accounts_Merge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Date: 2021/1/18 7:02 下午
 * Content:
 * 可以看成一个图，点是邮箱，如果两个邮箱是同一个人的，则有一条边
 * 一个人可以对应多个邮箱，但是一个邮箱只能对应一个人
 * <p>
 * 执行用时：29 ms, 在所有 Java 提交中击败了98.68%的用户
 * 内存消耗：43.7 MB, 在所有 Java 提交中击败了27.04%的用户
 */
public class Solution {

    public static final int N = 10010;

    static int[] p = new int[N];

    static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        for (int i = 0; i < N; i++) p[i] = i;  // 初始化并查集

        HashMap<String, Integer> emailToId = new HashMap<>();  // (email, id), id用来唯一标识邮箱
        HashMap<String, String> emailToName = new HashMap<>();  // (email, username)
        int index = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, index++);
                    emailToName.put(email, name);
                }
            }
        }

        // 根据邮箱合并
        for (List<String> account : accounts) {
            if (account.size() > 1) {
                int x = emailToId.get(account.get(1));
                for (int i = 2; i < account.size(); i++) {
                    int y = emailToId.get(account.get(i));
                    int p1 = find(x), p2 = find(y);
                    if (p1 != p2) p[p1] = p2;  // 合并邮箱id
                }
            }
        }

        // 将id映射到emails (find(id), emails)
        HashMap<Integer, List<String>> idToEmails = new HashMap<>();
        for (String email : emailToId.keySet()) {
            int id = emailToId.get(email);
            int f = find(id);
            List<String> t = idToEmails.getOrDefault(f, new ArrayList<>());
            t.add(email);
            idToEmails.put(f, t);
        }

        // 根据id得到emails，然后根据任意一个email得到用户名，然后得到(username, emails)
        List<List<String>> res = new ArrayList<>();
        for (Integer key : idToEmails.keySet()) {
            List<String> emails = idToEmails.get(key);
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            res.add(account);
        }

        return res;
    }

    private static List<List<String>> build(String[][] s) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            List<String> e = new ArrayList<>();
            for (int j = 0; j < s[i].length; j++) e.add(s[i][j]);
            res.add(e);
        }
        return res;
    }

    public static void main(String[] args) {

        String[][] t = {
                {"John", "johnsmith@mail.com", "john00@mail.com"},
                {"John", "johnnybravo@mail.com"},
                {"John", "johnsmith@mail.com", "john_newyork@mail.com"},
                {"Mary", "mary@mail.com"}
        };
        List<List<String>> accounts = build(t);
        List<List<String>> res = (new Solution()).accountsMerge(accounts);
        System.out.println(res);
    }
}
