package _0242_Valid_Anagram;

import _0076_Minimum_Window_Substring.Solution2;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] sFreq = new int[26];
        int[] tFreq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sFreq[s.charAt(i) - 'a']++;
            tFreq[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++)
            if (sFreq[i] != tFreq[i])
                return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).isAnagram("anagram", "nagaram"));
        System.out.println((new Solution()).isAnagram("rat", "car"));
    }
}
