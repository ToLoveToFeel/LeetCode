// Author  :  Wang Xiaoxiao
// Time    :  2020-01-26
package _0451_Sort_Characters_By_Frequency;

import java.util.*;

public class Solution {
    // Time Limit Exceeded
    // 时间复杂度：O()
    // 空间复杂度：O()
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c))
                map.put(c, 1);
            else
                map.put(c, map.get(c) + 1);
        }

        String res = "";
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet()); //转换为list
//        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
//                return o2.getValue().compareTo(o1.getValue());
//            }
//        });
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (int i = 0; i < list.size(); i++){
            char c = list.get(i).getKey();
            for (int j = 0; j < list.get(i).getValue(); j++)
                res += c;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).frequencySort("tree"));
        System.out.println((new Solution()).frequencySort("cccaaa"));
        System.out.println((new Solution()).frequencySort("Aabb"));
    }
}
