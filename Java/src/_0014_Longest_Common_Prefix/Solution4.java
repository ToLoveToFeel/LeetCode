package _0014_Longest_Common_Prefix;

/**
 * Date: 2020/8/29 9:23
 * Content:
 */
class Solution4 {
    private Boolean isCcommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != strs[i].charAt(j))
                    return false;
            }
        }
        return true;
    }

    // 二分查找
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs[0].length() == 0)
            return "";

        int minLength = strs[0].length();
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int low = 0, high = minLength;
        while (low < high) {
//            int mid = (high - low) / 2 + low;
            int mid = (high - low + 1) / 2 + low;  // 加1是为了防止无限循环，比如输入数据为{"a"}
            if (isCcommonPrefix(strs, mid)){
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    public static void main(String[] args) {
//        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"dog", "racecar", "car"};
        String[] strs = {"a"};
        System.out.println((new Solution4()).longestCommonPrefix(strs));
    }
}
