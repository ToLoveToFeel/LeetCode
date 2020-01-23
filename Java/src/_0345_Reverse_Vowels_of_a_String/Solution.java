package _0345_Reverse_Vowels_of_a_String;

import java.util.HashSet;

public class Solution {
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    private HashSet<Character> vowelSet;

    public String reverseVowels(String s) {
        // 创建元音字母集合
        char[] vowel = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        vowelSet = new HashSet<Character>();
        for (int i = 0; i < vowel.length; i++)
            vowelSet.add(vowel[i]);

        StringBuilder sb = new StringBuilder(s);

        int l = next_vowel(sb, 0);
        int r = prev_vowel(sb, s.length()-1);

        while (l < r){
            swap(sb, l, r);
            l = next_vowel(sb, l + 1);
            r = prev_vowel( sb, r - 1);
        }

        return sb.toString();
    }

    private int next_vowel(StringBuilder s, int index){
        for (int i = index; i < s.length(); i++)
            if (vowelSet.contains(s.charAt(i)))
                return i;
        return s.length();
    }

    private int prev_vowel(StringBuilder s, int index){
        for (int i = index; i >= 0; i--)
            if (vowelSet.contains(s.charAt(i)))
                return i;
        return -1;
    }

    private void swap(StringBuilder sb, int i, int j){
        char c = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, c);
    }

    public static void main(String[] args) {
        String s = "leetcode";

        System.out.println((new Solution()).reverseVowels(s));
    }
}
