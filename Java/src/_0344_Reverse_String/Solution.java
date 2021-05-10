package _0344_Reverse_String;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {

    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) swap(s, l++, r--);
    }

    private void swap(char[] s, int l, int r) {
        char c = s[l];
        s[l] = s[r];
        s[r] = c;
    }

    public static void main(String[] args) {

        char[] s = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(s);
        (new Solution()).reverseString(s);
        System.out.println(s);
    }
}
