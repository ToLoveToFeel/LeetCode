package _1208_Get_Equal_Substrings_Within_Budget;

/**
 * Date: 2021/2/5 8:35
 * Content:
 * 执行用时：5 ms, 在所有 Java 提交中击败了94.88%的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了43.22%的用户
 */
public class Solution {

    public int equalSubstring(String s, String t, int maxCost) {

        int n = s.length();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) cost[i] = Math.abs(s.charAt(i) - t.charAt(i));

        int res = 0;
        for (int i = 0, j = 0, sum = 0; i < n; i++) {
            sum += cost[i];
            while (sum > maxCost) sum -= cost[j++];
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).equalSubstring("abcd", "bcdf", 3));  // 3
    }
}
