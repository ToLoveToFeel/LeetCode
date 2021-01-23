package _0014_Longest_Common_Prefix;

/**
 * Date: 2020/8/29 9:23
 * Content:
 */
class Solution5 {

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

        if (strs.length == 0 || strs[0].length() == 0) return "";

        int minLength = strs[0].length();
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        // 保证 [0...low) 是最长前缀，在 [low...high] 中寻找结束点
        // 如果结束点是 high, substring(0, high) 会将数据全部截取下来
        int low = 0, high = minLength;
        while (low < high) {  // 如果 low==high ,此时公共前缀已经确定了
            // int mid = (high - low) / 2 + low;
            // high - low 为偶数时，有没有+1对 mid 的值没有影响  9 8  -->  (2-0)/2=1  (2-0+1)/2=1
            // high - low 为奇数时，+1对 mid 的值有影响         9   -->  (1-0)/2=0  (1-0+1)/2=1
            // 因为 isCcommonPrefix 判断的是 [0...mid) 范围的前缀，不+1的话如果 high - low = 1 的情况下，mid = 0,会陷入死循环
            int mid = (high - low + 1) / 2 + low;  // 加一的目的是防止死循环
            if (isCcommonPrefix(strs, mid)) low = mid;
            else high = mid - 1;
        }
        return strs[0].substring(0, low);
    }

    public static void main(String[] args) {

//        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"dog", "racecar", "car"};
        String[] strs = {"a"};
        System.out.println((new Solution5()).longestCommonPrefix(strs));
    }
}
