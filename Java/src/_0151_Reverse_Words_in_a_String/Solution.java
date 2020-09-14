package _0151_Reverse_Words_in_a_String;

/**
 * Date: 2020/9/14 10:13
 * Content:
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * Timeout
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int startIndex, endIndex;
        int index = s.length() - 1;
        while (index >= 0) {
            while (index >= 0 && s.charAt(index) == ' ')
                index--;
            endIndex = index + 1;
            while (index >= 0 && s.charAt(index) != ' ')
                index--;
            startIndex = index + 1;
            if (startIndex >= 0 && endIndex > startIndex) {
                sb.append(s, startIndex, endIndex);
                sb.append(' ');
            }
        }
        if (sb.length() > 0)
            sb.delete(sb.length() - 1, sb.length());  // 删除最后的空格

        return sb.toString();
    }

    public static void main(String[] args) {
//        String s = "the sky is blue";
//        String s = "  hello world!  ";
//        String s = "a good   example";
//        String s = "";
        String s = " ";
        System.out.println((new Solution()).reverseWords(s));
    }
}
