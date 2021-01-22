package _0162_Find_Peak_Element;

/**
 * Date: 2021/1/22 17:52
 * Content: https://www.bilibili.com/video/BV1Jz4y1Q7oF  时间：80:00
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：37.9 MB, 在所有 Java 提交中击败了89.21%的用户
 */
public class Solution {

    public int findPeakElement(int[] nums) {

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            // 不存在越界情况，如果越界，意味着mid = r，则l也必须为r，不能进入循环
            if (nums[mid] > nums[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        System.out.println((new Solution()).findPeakElement(nums));  // 5
    }
}
