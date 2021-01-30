package _0300_Longest_Increasing_Subsequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/9/3 20:26
 * Content: 贪心算法 + 二分查找
 * 时间复杂度：O(n^logn)
 * 空间复杂度：O(n)
 * https://www.acwing.com/video/1655/
 * 执行用时：8 ms, 在所有 Java 提交中击败了77.78%的用户
 * 内存消耗：38.1 MB, 在所有 Java 提交中击败了31.84%的用户
 */
public class Solution4 {

    public int lengthOfLIS(int[] nums) {

        List<Integer> q = new ArrayList<>();
        for (int x : nums) {
            if (q.isEmpty()  || x > q.get(q.size() - 1)) q.add(x);
            else {
                if (x <= q.get(0)) q.set(0, x);
                else {
                    // 找到小于x最大的数据
                    int l = 0, r = q.size() - 1;
                    while (l < r) {
                        int mid = l + r + 1 >> 1;
                        if (q.get(mid) < x) l = mid;  // 说明nums[mid] < x, nums[mid]是待选数据
                        else r = mid - 1;
                    }
                    q.set(r + 1, x);
                }
            }
        }
        return q.size();
    }

    public static void main(String[] args) {

//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};  // 4
//        int[] nums = {-2, -1};  // 2
//        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};  // 6
//        int[] nums = {0, 1, 1};  // 2
        int[] nums = {7, 7};  // 1
        System.out.println((new Solution4()).lengthOfLIS(nums));
    }
}
