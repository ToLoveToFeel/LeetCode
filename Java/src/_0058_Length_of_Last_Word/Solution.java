package _0058_Length_of_Last_Word;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.8 MB, 在所有 Java 提交中击败了53.95%的用户
 */
public class Solution {

    public int lengthOfLastWord(String s) {

        s = s.trim();
        if (s.length() == 0) return 0;

        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) != ' ') i--;
        return s.length() - 1 - i;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).lengthOfLastWord(" Hello World "));
    }
}
