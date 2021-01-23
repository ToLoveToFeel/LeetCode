package _0055_Jump_Game;

class Solution {

    // 1、构建一个数组maxEnd来存储每一个索引位置最远能走到的位置；
    // 2、遍历nums，如果元素的索引位置比当前最长能走到的位置远，说明这个索引位置就已经到达不了了。
    public boolean canJump(int[] nums) {

        int n = nums.length;
        if (n == 0) return true;

        int[] maxEnd = new int[n];  // maxEnd[i]记录从索引i能跳到的索引
        for (int i = 0; i < n; i++) maxEnd[i] = i + nums[i];

        int p = 0;  // p记录[0..i)能跳到的最远位置
        for (int i = 0; i < n; i++) {
            if (p >= n - 1) break;
            // 比如当前考察 i = 4，则要看maxEnd[0...3]能否到达 4, 之后才能更新 p
            if (i > p) return false;
            // 根据当前考察的元素索引更新能最远到达的位置
            p = Math.max(p, maxEnd[i]);
        }

        return true;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println((new Solution()).canJump(nums));
    }
}
