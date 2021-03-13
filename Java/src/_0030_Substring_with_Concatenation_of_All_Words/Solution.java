package _0030_Substring_with_Concatenation_of_All_Words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by WXX on 2021/3/13 21:59
 * 执行用时：20 ms, 在所有 Java 提交中击败了76.85%的用户
 * 内存消耗：39.3 MB, 在所有 Java 提交中击败了18.20%的用户
 */
public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> res = new ArrayList<>();
        if (s.length() == 0) return res;
        int n = s.length(), m = words.length, w = words[0].length();
        HashMap<String, Integer> tot = new HashMap<>();
        for (String word : words) tot.put(word, tot.getOrDefault(word, 0) + 1);

        for (int i = 0; i < w; i++) {
            HashMap<String, Integer> wd = new HashMap<>();
            int cnt = 0;
            for (int j = i; j + w - 1 < n; j += w) {
                if (j >= i + m * w) {
                    String word = s.substring(j - m * w, j - (m - 1) * w);
                    wd.put(word, wd.getOrDefault(word, 0) - 1);
                    if (wd.get(word) < tot.getOrDefault(word, 0)) cnt--;
                }
                String word = s.substring(j, j + w);
                wd.put(word, wd.getOrDefault(word, 0) + 1);
                if (wd.get(word) <= tot.getOrDefault(word, 0)) cnt++;
                if (cnt == m) res.add(j - (m - 1) * w);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println((new Solution()).findSubstring(s, words));
    }
}
