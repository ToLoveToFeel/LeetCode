package _0028_Implement_strStr;

/**
 * Date: 2020/9/19 21:22
 * Content:
 */
public class Solution {
    private int[] getNext(String T) {
        int[] next = new int[T.length()];
        next[0] = -1;  // next[1] 一定为 0

        int i = 0, j = -1;
        while (i < T.length() - 1) {  // 这里 -1 的原因是因为当 i=T.length()-2 时，下面的循环一定会进入到 if 语句中，会使 i++
            if (j == -1 || T.charAt(i) == T.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (haystack.length() < needle.length())
            return -1;

        int[] next = getNext(needle);  // 构造 next 表
        int i = 0, j = 0;  // 从起始开始匹配
        while (i < haystack.length() && j < needle.length()) {
            if (j < 0 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    public static void main(String[] args) {
//        String haystack = "hello";
//        String needle = "ll";
//        String haystack = "aaaaa";
//        String needle = "bba";
        String haystack = "mississippi";
        String needle = "issipi";
        System.out.println((new Solution()).strStr(haystack, needle));
    }
}
