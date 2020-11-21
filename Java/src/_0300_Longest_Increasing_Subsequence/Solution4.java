package _0300_Longest_Increasing_Subsequence;

import java.util.Arrays;

/**
 * Date: 2020/9/3 20:26
 * Content:
 * 贪心算法 + 二分查找
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
 */
// 时间复杂度：O(n^logn)
// 空间复杂度：O(n)
public class Solution4 {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;

        // tail存放尽量小的递增的数组
        // 10, 9, 2, 5, 3, 7, 101, 18
        // 2 3 7 18  -->  长度为4，因此返回4
        int[] tail = new int[nums.length];

        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int mid = (j - i) / 2 + i;
                if (num > tail[mid])
                    i = mid + 1;
                else
                    j = mid;
            }
            tail[i] = num;
            if (res == j)  // j没变，说明当前考察的num大于tail[0...res)
                res++;
        }

        return res;
    }

    public static void main(String[] args) {

//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
//        int[] nums = {-2, -1};
//        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        int[] nums = {10, 9, 2, 5, 3, 4};
//        int[] nums = {2, 3, 14, 20, 21, 18};  // 对应tail是2,3,18,20,21
        System.out.println((new Solution4()).lengthOfLIS(nums));
    }
}
