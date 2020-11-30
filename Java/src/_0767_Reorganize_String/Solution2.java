package _0767_Reorganize_String;

/**
 * Date: 2020/11/30 9:09
 * Content:
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.6 MB, 在所有 Java 提交中击败了83.12%的用户
 * https://leetcode-cn.com/problems/reorganize-string/solution/zhong-gou-zi-fu-chuan-by-leetcode-solution/
 */
public class Solution2 {

    public String reorganizeString(String S) {

        int n = S.length();
        if (n <= 1)
            return S;

        // 统计各个字母出现的次数
        int[] letters = new int[26];
        for (char c : S.toCharArray()) {
            letters[c - 'a']++;
        }
        // 记录出现次数最多的字母的次数
        int maxCount = 0;
        for (int i = 0; i < 26; i++) {
            maxCount = Math.max(maxCount, letters[i]);
        }
        if (maxCount > (n + 1) / 2)
            return "";

        char[] res = new char[n];
        int evenIndex = 0, oddIndex = 1;
        int half = n / 2;  // 如果大于 n/2，说明是n为奇数，maxCount = (n + 1) / 2
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while (letters[i] > 0 && letters[i] <= half && oddIndex < n) {
                res[oddIndex] = c;
                letters[i]--;
                oddIndex += 2;
            }
            while (letters[i] > 0) {
                res[evenIndex] = c;
                letters[i]--;
                evenIndex += 2;
            }
        }

        return new String(res);
    }

    public static void main(String[] args) {

        String S = "vvvlo";  // 正确答案是"vlvol"，但这种方式的输出为""
        System.out.println((new Solution2()).reorganizeString(S));

    }
}
