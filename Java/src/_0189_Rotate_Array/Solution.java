package _0189_Rotate_Array;

public class Solution {
    // 暴力解法
    // 时间复杂度：O(n*k)
    // 时间复杂度：O(1)
    public void rotate(int[] nums, int k) {

        if (k % nums.length == 0)
            return;

        for (int i = 0; i < k; i++){
            int temp = nums[nums.length-1];
            for (int j = nums.length - 1; j > 0; j--)
                nums[j] = nums[j-1];
            nums[0] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        (new Solution()).rotate(nums, k);
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }
}
