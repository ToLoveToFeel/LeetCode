package _1024_Video_Stitching;

import java.util.Arrays;

/**
 * Date: 2020/10/24 10:22
 * Content:
 * 贪心算法
 * 时间复杂度：O(T + N)  T为区间长度， N为子区间数量
 * 可以参照 Leetcode 55
 */
public class Solution2 {
    public int videoStitching(int[][] clips, int T) {
        int[] maxEnd = new int[T];  // 用于保存 以当前数字(下标)为起点 的区间的 最大的结束位置
        for (int[] clip : clips) {
            int start = clip[0];  // 区间开始
            int end = clip[1];  // 区间结束
            if (start < T)
                maxEnd[start] = Math.max(maxEnd[start], end);
        }

        int preEnd = 0;  // 记录 结果中上一次的最大结束位置(本轮的最小开始位置)
        int curEnd = 0;  // 记录当前遍历到的 区间最大结束位置
        int res = 0;  // 记录结果
        for (int i = 0; i < T; i++) {
            curEnd = Math.max(curEnd, maxEnd[i]);  // [0...i]为起始所能到达的最远距离
            if (i == curEnd)  // 当前元素 == 本区间最大元素(无法到达后续位置)
                return -1;
            if (i == preEnd) {  // 当前元素 == 上一个区间的最大元素
                res++;
                preEnd = curEnd;
            }
        }
        return res;
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
        System.out.println((new Solution2()).videoStitching(clips, T));
    }
}

 /*
根据maxEnd数组，计算最终结果
    因为maxEnd[i]数组为最大结束位置，因此：
        1、当前元素 == 本区间最大元素，
            即：区间断开，无法连续到后续位置，返回-1
        2、当前元素 == 上一个区间的最大结束元素，
            即：到达了上一个满足条件的区间的结束位置
            这时的last为当前最大的结束位置，我们将其放入满足条件的区间集合之中
            (因为本题只需要我们记录 满足条件的区间个数，因为只需要 更新count和pre 即可)
*/

