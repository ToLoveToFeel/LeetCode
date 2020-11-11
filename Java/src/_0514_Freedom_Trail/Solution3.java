package _0514_Freedom_Trail;

import java.util.*;

/**
 * Date: 2020/11/11 10:22
 * Content: 动态规划
 * Solution2 中 memo = new int[ring.length()][key.length()];
 * 状态：dp[ringIndex][keyIndex] : 当前12点对齐的是ring[ringIndex]，实现对齐key[keyIndex]到key末尾字符，所需的最少步数
 * 并且有 ring[ringIndex] == key[keyIndex]!!!
 * 状态转移：dp[i][j] = Math.min(dp[i][j], dp[index][j - 1] + minStep);
 *      index是key[j-1]这个字符在ring这个字符的下标
 *
 * 执行用时：14 ms, 在所有 Java 提交中击败了58.22%的用户
 * 内存消耗：39.1 MB, 在所有 Java 提交中击败了70.80%的用户
 */
public class Solution3 {

    public int findRotateSteps(String ring, String key) {

        int m = ring.length();
        int n = key.length();

        Map<Character, List<Integer>> map = new HashMap<>();;  // 记录ring中的每个字符出现在ring中的下标位置
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            char c = ring.charAt(i);
            if (!map.containsKey(c)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(c, list);
            } else {
                List<Integer> list = map.get(c);
                list.add(i);
                map.put(c, list);
            }
        }

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0] = Math.min(i, m - i);  // 最开始ring[0]对应12点钟，如果要使得ring[i]对应12点钟，需要旋转的最少次数
        }
        for (int j = 1; j < n; j++) {  // key[j]

            char c = key.charAt(j);  // 当前需要对齐的字符
            for (Integer i : map.get(c)) {

                char preChar = key.charAt(j - 1);  // 上一次考虑到的字符，也就是上一次正对12点的字符
                for (Integer index : map.get(preChar)) {
                    // 下面三行是计算由上一次正对12点的字符 转到 这一次需要正对12点的字符的最少转动次数
                    int step1 = Math.abs(i - index);  // 顺时针旋转需要旋转的次数
                    int step2 = Math.abs(ring.length() - step1);  // 逆时针旋转需要旋转的次数
                    int minStep = Math.min(step1, step2);
                    dp[i][j] = Math.min(dp[i][j], dp[index][j - 1] + minStep);  // ring[index] == key[j-1]
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            res = Math.min(res, dp[i][n - 1]);
        }

        return res + key.length();
    }

    public static void main(String[] args) {

        String ring = "godding";
        String key = "gd";
        System.out.println((new Solution3()).findRotateSteps(ring, key));
    }
}
