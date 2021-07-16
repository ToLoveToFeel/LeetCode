package _0581_Shortest_Unsorted_Continuous_Subarray;

/**
 * Date: 2021/7/16 21:55
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：39.5 MB, 在所有 Java 提交中击败了81.63%的用户
 */
public class Solution {

    public int findUnsortedSubarray(int[] nums) {
        int l = 0, r = nums.length - 1;
        // 处理左端点
        while (l + 1 < nums.length && nums[l + 1] >= nums[l]) l++;
        if (l == r) return 0;  // 说明整个数组都是升序的
        for (int i = l + 1; i < nums.length; i++)
            while (l >= 0 && nums[l] > nums[i])
                l--;

        // 处理右端点
        while (r - 1 >= 0 && nums[r - 1] <= nums[r]) r--;
        for (int i = r - 1; i >= 0; i--)
            while (r < nums.length && nums[r] < nums[i])
                r++;
        return r - l - 1;  // 区间[l+1, r-1]需要调整
    }

    public static void main(String[] args) {

        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println((new Solution()).findUnsortedSubarray(nums));  // 5
    }
}
