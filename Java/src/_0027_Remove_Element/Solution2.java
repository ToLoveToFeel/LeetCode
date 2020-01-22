package _0027_Remove_Element;

public class Solution2 {
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int removeElement(int[] nums, int val) {
        int newLength = nums.length;
        int i = 0;
        while (i < newLength)
            if (nums[i] == val)
                nums[i] = nums[--newLength];
            else
                i++;

            return newLength;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;

        System.out.println((new Solution2()).removeElement(nums, val));
    }
}
