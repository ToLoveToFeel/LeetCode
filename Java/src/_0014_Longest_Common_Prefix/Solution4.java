package _0014_Longest_Common_Prefix;

/**
 * Date: 2020/8/29 9:23
 * Content:
 */
class Solution4 {

    private Boolean isCcommonPrefix(String[] strs, int length) {

        String str0 = strs[0].substring(0, length + 1);
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j <= length; j++) {
                if (str0.charAt(j) != strs[i].charAt(j))
                    return false;
            }
        }
        return true;
    }

    // 二分查找，这种二分查找法比较好，比Solution5容易理解
    // 因为和Solution5 的 isCcommonPrefix 实现有区别，因此 longestCommonPrefix 中实现由区别
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0 || strs[0].length() == 0) return "";

        int minLength = strs[0].length();
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        // 保证 [0...low) 是最长前缀，在 [low...high] 中寻找结束点
        // 如果结束点是 high, substring(0, high) 会将数据全部截取下来
        int low = 0, high = minLength - 1;
        while (low <= high) {  // 在 low == high 的情况下，还要考虑 low 这个位置是不是公共前缀
            int mid = (high - low) / 2 + low;
            if (isCcommonPrefix(strs, mid)) low = mid + 1;
            else high = mid - 1;
        }
        return strs[0].substring(0, low);
    }

    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"dog", "racecar", "car"};
//        String[] strs = {"a"};
        System.out.println((new Solution4()).longestCommonPrefix(strs));
    }
}
