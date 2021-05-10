package _0345_Reverse_Vowels_of_a_String;

/**
 * Date: 2021/5/10 22:26
 */
public class Solution {

    String t = "aeiou";

    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0, j = cs.length - 1; i < j; i++, j--) {
            while (i < j && !check(cs[i])) i++;
            while (i < j && !check(cs[j])) j--;
            char t = cs[i]; cs[i] = cs[j]; cs[j] = t;
        }
        return new String(cs);
    }

    private boolean check(char c) {
        return t.indexOf(Character.toLowerCase(c)) != -1;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).reverseVowels("hello"));  // holle
    }
}
