// Author  :  Wang Xiaoxiao
// Time    :  2020-01-26
package _0451_Sort_Characters_By_Frequency;

import java.util.*;

/**
 * 执行用时：17 ms, 在所有 Java 提交中击败了53.02%的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了92.90%的用户
 */
public class Solution {

    public String frequencySort(String s) {

        HashMap<Character, Integer> cnt = new HashMap<>();
        for (char x : s.toCharArray()) cnt.put(x, cnt.getOrDefault(x, 0) + 1);

        List<Character> list = new ArrayList<>(cnt.keySet());  // 转换为list
        list.sort((a, b) -> cnt.get(b).compareTo(cnt.get(a)));
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            for (int j = 0; j < cnt.get(c); j++)
                sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).frequencySort("tree"));
        System.out.println((new Solution()).frequencySort("cccaaa"));
        System.out.println((new Solution()).frequencySort("Aabb"));
    }
}
