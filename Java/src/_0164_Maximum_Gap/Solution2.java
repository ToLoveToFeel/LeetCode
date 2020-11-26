package _0164_Maximum_Gap;

import java.util.Arrays;

/**
 * Date: 2020/11/26 9:34
 * Content: 桶排序：桶内放置元素的范围是多少？一共多少个桶？
 * <p>
 * https://leetcode-cn.com/problems/maximum-gap/solution/zui-da-jian-ju-by-leetcode-solution/
 * https://leetcode-cn.com/problems/maximum-gap/solution/python3-tong-pai-xu-by-yanghk/
 * <p>
 * 执行用时：6 ms, 在所有 Java 提交中击败了15.33%的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了87.36%的用户
 */
public class Solution2 {

    public int maximumGap(int[] nums) {

        int n = nums.length;
        if (n < 2) {
            return 0;
        }

        int max = Arrays.stream(nums).max().getAsInt();
        ;
        int min = Arrays.stream(nums).min().getAsInt();
        ;
        int d = Math.max(1, (max - min) / (n - 1));  // 桶内放置元素的范围是多少？
        int bucketNum = (max - min) / d + 1;  // 一共多少个桶？

        int[][] bucket = new int[bucketNum][2];
        for (int i = 0; i < bucketNum; ++i) {
            Arrays.fill(bucket[i], -1);  // 存储 (桶内最小值，桶内最大值) 对， (-1, -1) 表示该桶是空的
        }

        for (int i = 0; i < n; i++) {
            int idx = (nums[i] - min) / d;
            if (bucket[idx][0] == -1) {
                bucket[idx][0] = bucket[idx][1] = nums[i];
            } else {
                bucket[idx][0] = Math.min(bucket[idx][0], nums[i]);
                bucket[idx][1] = Math.max(bucket[idx][1], nums[i]);
            }
        }

        int res = 0;
        int prev = -1;  // 前一个非空桶的索引
        for (int i = 0; i < bucketNum; i++) {
            if (bucket[i][0] == -1) {
                continue;
            }
            if (prev != -1) {
                res = Math.max(res, bucket[i][0] - bucket[prev][1]);
            }
            prev = i;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {3, 6, 9, 1};
        System.out.println((new Solution2()).maximumGap(nums));
    }
}

/*
 对于：{3, 6, 9, 1}
    d = (9-1)/(4-1) = 2 ，所以数据跨度为2
    bucketNum = (9-1)/2 + 1 = 5

    [1,3)  [3,5)  [5,7)  [7,9)  [9,11)
 */

