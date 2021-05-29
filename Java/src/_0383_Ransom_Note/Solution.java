package _0383_Ransom_Note;

import java.util.HashMap;

/**
 * Date: 2021/5/29 18:57
 */
public class Solution {

    public boolean canConstruct(String a, String b) {
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char c : b.toCharArray()) hash.put(c, hash.getOrDefault(c, 0) + 1);
        for (char c : a.toCharArray())
            if (!hash.containsKey(c) || hash.get(c) == 0) return false;
            else hash.put(c, hash.get(c) - 1);
        return true;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).canConstruct("a", "b"));  // false
    }
}
