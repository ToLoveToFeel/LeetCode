package _0055_Jump_Game;

class Solution {
    // 1、构建一个数组maxEnd来存储每一个索引位置最远能走到的位置；
    // 2、遍历nums，如果元素的索引位置比当前最长能走到的位置远，说明这个索引位置就已经到达不了了。
    public boolean canJump(int[] nums) {
        if (nums.length == 0)
            return true;

        int[] maxEnd = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            maxEnd[i] = i + nums[i];

        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (longest >= nums.length - 1)
                break;
            if (i > longest)  // 比如当前考察 i = 4,则要看maxEnd[0...3]能否到达 4, 之后才能更新 longest
                return false;
            // 根据当前考察的元素索引更新能最远到达的位置
            longest = Math.max(longest, maxEnd[i]);
        }

        return true;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println((new Solution()).canJump(nums));
    }
}
