package _0049_Group_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 时间复杂度：O(n*s*log(s))，s是strs中字符串最大的长度
 * 空间复杂度：O(n * s)
 * 执行用时：7 ms, 在所有 Java 提交中击败了95.84%的用户
 * 内存消耗：41.7 MB, 在所有 Java 提交中击败了50.28%的用户
 */
public class Solution2 {

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0)
            return new ArrayList<>();

        // <K，V>：<排好序的字符串，对应原来的字符串链表>
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String word : strs) {

            String sortedWord = stringSort(word);

            if (!hashMap.containsKey(sortedWord))
                hashMap.put(sortedWord, new ArrayList<>());
            hashMap.get(sortedWord).add(word);
        }

        return new ArrayList<>(hashMap.values());
    }

    private String stringSort(String s) {

        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        return String.valueOf(chs);
    }

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = (new Solution2()).groupAnagrams(strs);

        for (int i = 0; i < res.size(); i++) {
            System.out.print("[");
            int count = 0;
            for (int j = 0; j < res.get(i).size(); j++) {
                count++;
                System.out.print(res.get(i).get(j));
                if (count != res.get(i).size())
                    System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}
