package _0228_Summary_Ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/8/30 21:19
 * Content:
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        int start = 0;
        while (start < nums.length) {
            StringBuilder sb = new StringBuilder(nums[start] + "");
            int end = start;
            while (end + 1 < nums.length && nums[end + 1] == nums[start] + end - start + 1) {
                end++;
            }
            if (end != start) {
                sb.append("->");
                sb.append(nums[end]);
                start = end;
            }
            start++;
            list.add(sb.toString());
        }
        return list;
    }

    public static void main(String[] args) {
//        int[] nums = {0, 1, 2, 4, 5, 7};
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        System.out.println((new Solution()).summaryRanges(nums));
    }
}
