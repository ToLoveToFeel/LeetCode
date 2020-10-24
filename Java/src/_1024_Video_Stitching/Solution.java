package _1024_Video_Stitching;

import java.util.Arrays;

/**
 * Date: 2020/10/24 10:22
 * Content:
 * 动态规划：
 * 状态：dp[i]: 将区间[0...i]覆盖所需要的最少区间的数量
 * 状态转移： dp[i] = Math.min(dp[i], dp[clip[j][0]] + 1)        clip[j][0] < i && i <= clip[j][1]
 * <p>
 * 时间复杂度：O(TxN)  T为区间长度， N为子区间数量
 */
public class Solution {
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);  // 不能是 Integer.MAX_VALUE，比如测试用例 clips={{0, 2}, {4, 8}}, T=5
        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1])
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
            }
        }

        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }

    public static void main(String[] args) {
//        int[][] clips = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
//        int T = 10;
//        int[][] clips = {{0, 1}, {1, 2}};
//        int T = 5;
//        int[][] clips = {{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}};
//        int T = 9;
//        int[][] clips = {{0, 4}, {2, 8}};
//        int T = 5;
        int[][] clips = {{0, 2}, {4, 8}};
        int T = 5;
        System.out.println((new Solution()).videoStitching(clips, T));
    }
}
