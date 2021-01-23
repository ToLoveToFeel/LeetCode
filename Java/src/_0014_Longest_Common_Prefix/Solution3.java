package _0014_Longest_Common_Prefix;

/**
 * Date: 2020/8/29 9:23
 * Content:
 * 时间复杂度：O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量。
 * 时间复杂度的递推式是 T(n)=2⋅T(n、2)+O(m)，通过计算可得)T(n)=O(mn)。
 * <p>
 * 空间复杂度：O(mlogn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量。
 */
class Solution3 {

    private String commonPrefix(String s1, String s2) {

        int length = Math.min(s1.length(), s2.length());
        int index = 0;

        while (index < length && s1.charAt(index) == s2.charAt(index)) index++;

        return s1.substring(0, index);
    }

    private String longestCommonPrefix(String[] strs, int start, int end) {

        if (start == end) return strs[start];

        int mid = (end - start) / 2 + start;
        String leftPrefix = longestCommonPrefix(strs, start, mid);
        String rightPrefix = longestCommonPrefix(strs, mid + 1, end);

        return commonPrefix(leftPrefix, rightPrefix);
    }

    // 分治算法
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0 || strs[0].length() == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"dog", "racecar", "car"};
        System.out.println((new Solution3()).longestCommonPrefix(strs));
    }
}
