package _0014_Longest_Common_Prefix;

/**
 * Date: 2020/8/29 9:23
 * Content:
 */
class Solution2 {
    private String longestCommonPrefix(String s1, String s2) {
        int length = Math.min(s1.length(), s2.length());
        int index = 0;

        while (index < length && s1.charAt(index) == s2.charAt(index)) {
            index ++;
        }

        return s1.substring(0, index);
    }

    // 横向扫描
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs[0].length() == 0)
            return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0)
                break;
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"dog", "racecar", "car"};
        System.out.println((new Solution2()).longestCommonPrefix(strs));
    }
}
