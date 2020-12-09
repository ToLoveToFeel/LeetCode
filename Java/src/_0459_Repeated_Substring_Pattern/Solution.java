package _0459_Repeated_Substring_Pattern;

/**
 * Date: 2020/12/9 20:56
 * Content:
 * https://leetcode-cn.com/problems/repeated-substring-pattern/solution/jian-dan-ming-liao-guan-yu-javaliang-xing-dai-ma-s/
 * 如果 s.length() == 1, 会返回 false
 * 如果 s.length() > 1, 如果 s 是由多个子串重复构成，则至少两个相同子串
 * 所以 str (s+s) 至少四个相同子串，去除第一个字符 和 最后一个字符 仍然包含 s
 * <p>
 * 执行用时：99 ms, 在所有 Java 提交中击败了26.91%的用户
 * 内存消耗：39 MB, 在所有 Java 提交中击败了68.94%的用户
 */
public class Solution {

    public boolean repeatedSubstringPattern(String s) {

        String str = s + s;
        // 去除第一个字符 和 最后一个字符
        return str.substring(1, str.length() - 1).contains(s);
    }

    public static void main(String[] args) {

        // true
        System.out.println((new Solution()).repeatedSubstringPattern("abab"));
        // false
        System.out.println((new Solution()).repeatedSubstringPattern("aba"));
        // true
        System.out.println((new Solution()).repeatedSubstringPattern("abcabcabcabc"));
    }
}
