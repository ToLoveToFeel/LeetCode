package _0049_Group_Anagrams;

import java.util.*;

/**
 * 时间复杂度：O(n*s*log(s))，s是strs中字符串最大的长度
 * 空间复杂度：O(n * s)
 * 执行用时：7 ms, 在所有 Java 提交中击败了95.84%的用户
 * 内存消耗：41.7 MB, 在所有 Java 提交中击败了50.28%的用户
 */
public class Solution2 {

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0) return new ArrayList<>();

        // <K，V>：<排好序的字符串，对应原来的字符串链表>
        HashMap<String, List<String>> hash = new HashMap<>();
        for (String word : strs) {
            String t = stringSort(word);
            if (!hash.containsKey(t)) hash.put(t, new ArrayList<>());
            hash.get(t).add(word);
        }

        return new ArrayList<>(hash.values());
    }

    private String stringSort(String s) {

        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        return String.valueOf(chs);
    }

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println((new Solution2()).groupAnagrams(strs));
    }
}
