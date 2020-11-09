package _0000_study._leetcode._swordoffer._058_Reverse_Words_in_a_String_I;

/**
 * Date: 2020/9/14 10:13
 * Content:
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * Timeout
 */
public class Solution3 {

    public String reverseWords(String s) {
        s = s.trim();
        if (s.equals(""))
            return "";

        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        sb.append(words[words.length - 1]);
        for (int i = words.length - 2; i >= 0; i--) {
            sb.append(' ');
            sb.append(words[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
//        String s = "  hello world!  ";
//        String s = "a good   example";
//        String s = "";
//        String s = " ";
        System.out.println((new Solution3()).reverseWords(s));
    }
}
