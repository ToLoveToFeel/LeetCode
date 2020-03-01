package _0055_Jump_Game;

class Solution {
    // 1、构建一个list来存储每一个索引位置最远能走到的位置；
    // 2、遍历nums，如果元素的索引位置比当前最长能走到的位置远，说明这个索引位置就已经到达不了了。
    public boolean canJump(int[] nums) {
        if (nums.length == 0)
            return true;

        int[] ls = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            ls[i] = i + nums[i];

        int longest = 0;
        for (int i = 0; i < nums.length; i++){
            if (longest >= nums.length - 1)
                break;
            if (i > longest)
                break;
            // 根据当前考察的元素索引更新能最远到达的位置
            longest = Math.max(longest, ls[i]);
        }

        return longest >= nums.length - 1;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println((new Solution()).canJump(nums));
    }
}
