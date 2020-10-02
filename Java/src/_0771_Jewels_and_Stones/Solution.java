package _0771_Jewels_and_Stones;

import java.util.HashSet;
import java.util.Set;

/**
 * Date: 2020/10/2 9:28
 * Content:
 * 哈希表
 */
public class Solution {
    public int numJewelsInStones(String J, String S) {
        if (J.equals("") || S.equals(""))
            return 0;

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++)
            set.add(J.charAt(i));

        int res = 0;
        for (int i = 0; i < S.length(); i++)
            if (set.contains(S.charAt(i)))
                res++;

        return res;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println((new Solution()).numJewelsInStones(J, S));
    }
}
