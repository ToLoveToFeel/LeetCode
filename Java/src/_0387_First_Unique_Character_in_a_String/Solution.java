package _0387_First_Unique_Character_in_a_String;

/**
 * 哈希表
 * 执行用时：7 ms, 在所有 Java 提交中击败了82.57%的用户
 * 内存消耗：38.9 MB, 在所有 Java 提交中击败了78.04%的用户
 */
public class Solution {

    public int firstUniqChar(String s) {

        char[] cs = s.toCharArray();
        int[] f = new int[26];
        for (char c : cs) f[c - 'a']++;
        for (int i = 0; i < cs.length; i++)
            if (f[cs[i] - 'a'] == 1)
                return i;
        return -1;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).firstUniqChar("loveleetcode"));
    }
}