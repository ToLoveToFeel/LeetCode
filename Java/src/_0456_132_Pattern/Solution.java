package _0456_132_Pattern;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 2021/3/24 4:02 下午
 * Content: 单调递减栈：从后向前遍历所有元素，使用right记录小于当前考察值的最大值
 * 执行用时：10 ms, 在所有 Java 提交中击败了33.58%的用户
 * 内存消耗：39.4 MB, 在所有 Java 提交中击败了5.01%的用户
 */
public class Solution {

    public boolean find132pattern(int[] nums) {

        Deque<Integer> stk = new ArrayDeque<>();
        int right = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < right) return true;
            while (!stk.isEmpty() && nums[i] > stk.peek()) {
                right = Math.max(right, stk.remove());
            }
            stk.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {

        // false
        System.out.println((new Solution()).find132pattern(new int[]{1, 2, 3, 4}));
    }
}
