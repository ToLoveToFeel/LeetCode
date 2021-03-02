package _0673_Number_of_Longest_Increasing_Subsequence;

/**
 * Created by WXX on 2021/3/2 15:08
 * 执行用时：23 ms, 在所有 Java 提交中击败了93.39%的用户
 * 内存消耗：37.9 MB, 在所有 Java 提交中击败了92.39%的用户
 */
public class Solution {

    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;
        int[] f = new int[n], g = new int[n];

        int maxv = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            f[i] = g[i] = 1;
            for (int j = 0; j < i; j++)
                if (nums[j] < nums[i]) {
                    if (f[i] < f[j] + 1) {
                        f[i] = f[j] + 1; g[i] = g[j];
                    } else if (f[i] == f[j] + 1) g[i] += g[j];
                }
            if (maxv < f[i]) {
                maxv = f[i]; cnt = g[i];
            } else if (maxv == f[i]) cnt += g[i];
        }
        return cnt;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 4, 7};
        System.out.println((new Solution()).findNumberOfLIS(nums));
    }
}
