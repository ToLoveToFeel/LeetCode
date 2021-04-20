package _0028_Implement_strStr;

/**
 * Date: 2021/4/20 10:00
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：37.2 MB, 在所有 Java 提交中击败了57.92%的用户
 */
public class Solution2 {

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {

        System.out.println((new Solution2()).strStr("", ""));  // 0
        System.out.println((new Solution2()).strStr("hello", "ll"));  // 2
        System.out.println((new Solution2()).strStr("aaaaa", "bba"));  // -1
        System.out.println((new Solution2()).strStr("mississippi", "issippi"));  // 4
    }
}
