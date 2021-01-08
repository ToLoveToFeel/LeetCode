package _0189_Rotate_Array;

import _0000_study._common.Output;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution3 {

    public void rotate(int[] nums, int k) {

        if (k % nums.length == 0) return;

        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 2;
        (new Solution3()).rotate(nums, k);
        Output.OutputBasicArray1D(nums);
    }
}
