package _0336_Palindrome_Pairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by WXX on 2021/2/27 10:21
 * 执行用时：78 ms, 在所有 Java 提交中击败了34.95%的用户
 * 内存消耗：40.2 MB, 在所有 Java 提交中击败了82.04%的用户
 */
public class Solution {

    private boolean check(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {

        HashMap<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < words.length; i++)
            hash.put(new StringBuilder(words[i]).reverse().toString(), i);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            for (int j = 0; j <= w.length(); j++) {
                String left = w.substring(0, j), right = w.substring(j);
                // 分析中的第一种情况
                if (check(right) && hash.containsKey(left) && hash.get(left) != i)
                    res.add(new ArrayList<>(Arrays.asList(i, hash.get(left))));
                // 分析中的第二种情况
                if (check(left) && hash.containsKey(right) && hash.get(right) != i
                        && w.length() != words[hash.get(right)].length())
                    res.add(new ArrayList<>(Arrays.asList(hash.get(right), i)));
            }
        }
        return res;
    }

    public static void main(String[] args) {

        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println((new Solution()).palindromePairs(words));
    }
}
