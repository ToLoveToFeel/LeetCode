package _0189_Rotate_Array;

import _0000_study._common.Output;

/**
 * 使用反转
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution4 {
    /*
        这个方法基于这个事实：当我们旋转数组 k 次， k%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
        在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n - k 个元素，就能得到想要的结果
     */
    public void rotate(int[] nums, int k) {

        if (k % nums.length == 0) return;

        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 2;
        (new Solution4()).rotate(nums, k);
        Output.OutputBasicArray1D(nums);
    }
}
