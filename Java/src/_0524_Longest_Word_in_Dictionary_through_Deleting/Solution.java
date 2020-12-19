package _0524_Longest_Word_in_Dictionary_through_Deleting;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/12/19 16:09
 * Content: 模拟整个过程即可，遍历字符串数组，如果是子序列，并且长度更长 或者 长度相等且字典序更小，则更新结果
 * <p>
 * 执行用时：29 ms, 在所有 Java 提交中击败了45.48%的用户
 * 内存消耗：39.3 MB, 在所有 Java 提交中击败了83.18%的用户
 */
public class Solution {

    // 判断 a 是不是 b 的子序列
    private boolean check(String a, String b) {

        if (a.length() > b.length())
            return false;

        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j))
                i++;
            j++;
        }

        return i == a.length();
    }

    public String findLongestWord(String s, List<String> d) {

        String res = "";
        for (String str : d) {
            if (check(str, s)) {
                if (res.isEmpty() ||
                        res.length() < str.length() ||
                        (res.length() == str.length() && str.compareTo(res) < 0)) {
                    res = str;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        String s = "abpcplea";
        List<String> d = new ArrayList<>();
        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");
        System.out.println((new Solution()).findLongestWord(s, d));
    }
}
