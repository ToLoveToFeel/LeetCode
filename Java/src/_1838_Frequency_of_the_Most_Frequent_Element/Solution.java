package _1838_Frequency_of_the_Most_Frequent_Element;

import java.util.Arrays;

/**
 * Date: 2021/7/19 10:31
 * Content:
 * 执行用时：76 ms, 在所有 Java 提交中击败了21.04%的用户
 * 内存消耗：47.3 MB, 在所有 Java 提交中击败了87.66%的用户
 */
public class Solution {

    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] s = new long[n + 1];
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1];

        int res = 0;
        for (int i = 0; i < n; i++) {  // 枚举区间结束端点:i
            int l = 0, r = i;
            while (l < r) {  // 满足操作次数小于等于k的最左侧位置
                int mid = l + r >> 1;
                long t = (long) (i - mid + 1) * nums[i] - (s[i + 1] - s[mid]);  // nums[mid]~nums[i]
                if (t <= k) r = mid;
                else l = mid + 1;
            }
            res = Math.max(res, i - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 4};
        System.out.println((new Solution()).maxFrequency(nums, 5));  // 3
    }
}
