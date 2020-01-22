package _0027_Remove_Element;

class Solution {
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int removeElement(int[] nums, int val) {
        int k = 0;  // nums[0...k)中的元素均为删除val后的元素

        for (int i = 0; i < nums.length; i++)  // 两个索引，一个跟踪当前考察的元素，另一个考察删除val最新的索引
            if (nums[i] != val)
                nums[k++] = nums[i];

        return k;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;

        System.out.println((new Solution()).removeElement(nums, val));
    }
}
