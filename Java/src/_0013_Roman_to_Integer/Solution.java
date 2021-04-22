package _0013_Roman_to_Integer;

import java.util.HashMap;

/**
 * Date: 2020/8/28 16:11
 * Content:
 */
class Solution {

    public int romanToInt(String s) {

        HashMap<Character, Integer> hash = new HashMap<>();
        hash.put('I', 1); hash.put('V', 5);
        hash.put('X', 10); hash.put('L', 50);
        hash.put('C', 100); hash.put('D', 500);
        hash.put('M', 1000);

        char[] cs = s.toCharArray();

        int res = 0;
        for (int i = 0; i < cs.length; i++) {
            if (i + 1 < cs.length && hash.get(cs[i]) < hash.get(cs[i + 1])) res -= hash.get(cs[i]);
            else res += hash.get(cs[i]);
        }
        return res;
    }

    public static void main(String[] args) {

        String s = "III";
        System.out.println((new Solution()).romanToInt(s));
    }
}
