package _0151_Reverse_Words_in_a_String;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Date: 2020/9/14 10:13
 * Content:
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * Solution2的简洁版本
 */
public class Solution2 {

    public String reverseWords(String s) {

        s = s.trim();
        List<String> words = Arrays.asList(s.split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }

    public static void main(String[] args) {

        String s = "the sky is blue";
//        String s = "  hello world!  ";
//        String s = "a good   example";
//        String s = "";
//        String s = " ";
        System.out.println((new Solution2()).reverseWords(s));
    }
}
