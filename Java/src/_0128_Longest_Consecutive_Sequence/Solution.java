package _0128_Longest_Consecutive_Sequence;

import java.util.HashSet;
import java.util.Set;

/**
 * Date: 2020/9/8 7:43
 * Content:
 * 时间复杂度：O(n)，外层循环需要 O(n) 的时间复杂度，只有当一个数是连续序列的第一个数的情况下才会进入内层循环，
 * 然后在内层循环中匹配连续序列中的数，因此数组中的每个数只会进入内层循环一次。根据上述分析可知，总时间复杂度为
 * O(n)
 *
 * 空间复杂度：O(n)
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        int res = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {  // 如果存在num-1，则以num-1开始的连续序列最长
                int length = 1;
                int curNum = num + 1;

                while (set.contains(curNum)) {
                    curNum++;
                    length++;
                }
                res = Math.max(res, length);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 4, 2};
        System.out.println((new Solution()).longestConsecutive(nums));
    }
}
