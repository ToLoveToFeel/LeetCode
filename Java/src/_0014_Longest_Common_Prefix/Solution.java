package _0014_Longest_Common_Prefix;

/**
 * Date: 2020/8/29 9:23
 * Content:
 */
class Solution {
    // 纵向扫描
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs[0].length() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {  // 考虑后面n-1一个字符串
                if ((i >= strs[j].length()) || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"dog", "racecar", "car"};
        System.out.println((new Solution()).longestCommonPrefix(strs));
    }
}
