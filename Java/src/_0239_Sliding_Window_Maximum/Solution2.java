package _0239_Sliding_Window_Maximum;

import _0000_study._common.Output;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 2020/11/9 15:27
 * Content: 时间复杂度：O(n)
 * https://www.acwing.com/video/202/
 * 执行用时：33 ms, 在所有 Java 提交中击败了38.85%的用户
 * 内存消耗：50.1 MB, 在所有 Java 提交中击败了73.34%的用户
 */
public class Solution2 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];
        int index = 0;

        // 双向队列 保证队列中数组位置的数值按从大到小排序(严格递减)
        // 队首保存着当前滑动窗口最大值对应的索引
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (q.size() != 0 && i - k + 1 > q.getFirst()) q.removeFirst();  // 剔除过时的元素
            while (q.size() != 0 && nums[q.getLast()] <= nums[i]) q.removeLast();  // 删除队列中小于等于 当前元素 的元素的索引
            q.addLast(i);  // 添加新元素
            if (i >= k - 1) res[index++] = nums[q.getFirst()];
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = (new Solution2()).maxSlidingWindow(nums, k);

        Output.OutputBasicArray1D(res);
    }
}
