package _0228_Summary_Ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/8/30 21:19
 * Content:
 * 执行用时：5 ms, 在所有 Java 提交中击败了87.16%的用户
 * 内存消耗：36.8 MB, 在所有 Java 提交中击败了64.94%的用户
 */
class Solution {

    public List<String> summaryRanges(int[] nums) {

        List<String> list = new ArrayList<>();

        int start = 0;
        while (start < nums.length) {
            StringBuilder sb = new StringBuilder(nums[start] + "");
            int end = start + 1;
            while (end < nums.length && nums[end] == nums[start] + end - start) end++;

            if (end != start + 1) sb.append("->").append(nums[end - 1]);

            start = end;
            list.add(sb.toString());
        }
        return list;
    }

    public static void main(String[] args) {

//        int[] nums = {0, 1, 2, 4, 5, 7};  // [0->2, 4->5, 7]
        int[] nums = {0, 2, 3, 4, 6, 8, 9};  // [0, 2->4, 6, 8->9]
        System.out.println((new Solution()).summaryRanges(nums));
    }
}
