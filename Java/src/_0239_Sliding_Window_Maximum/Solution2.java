package _0239_Sliding_Window_Maximum;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Date: 2020/11/9 15:27
 * Content: 时间复杂度：O(n)
 * https://leetcode-cn.com/problems/sliding-window-maximum/solution/shuang-xiang-dui-lie-jie-jue-hua-dong-chuang-kou-2/
 * 双端队列
 * <p>
 * 执行用时：33 ms, 在所有 Java 提交中击败了38.85%的用户
 * 内存消耗：50.1 MB, 在所有 Java 提交中击败了73.34%的用户
 */
public class Solution2 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length - k + 1;
        if (length <= 0)
            throw new IllegalArgumentException("Input error!");

        int[] res = new int[length];
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序(严格递减)
        Deque<Integer> deque = new LinkedList<>();
        int l = 0, r = 0;  // 滑动窗口 [l...r]
        // 还未形成长度为 k 的滑动窗口
        while (r - l + 1 <= k) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[r]) {
                deque.removeLast();
            }
            deque.addLast(r);
            if (r - l + 1 == k)  // 滑动窗口已经形成，直接跳出循环
                break;
            r++;
        }
        // 已经形成长度为 k 的滑动窗口
        while (r < nums.length) {
            // 得到一个结果
            res[l] = nums[deque.getFirst()];
            // 滑动窗口向右移动一位
            l++;
            r++;
            if (r == nums.length)  // 滑动窗口已经越界，直接退出
                break;
            if (deque.getFirst() < l)
                deque.removeFirst();
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[r]) {
                deque.removeLast();
            }
            deque.addLast(r);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = (new Solution2()).maxSlidingWindow(nums, k);
//        int[] nums = {1};
//        int k = 1;
//        int[] res = (new Solution2()).maxSlidingWindow(nums, k);
//        int[] nums = {1, -1};
//        int k = 1;
//        int[] res = (new Solution2()).maxSlidingWindow(nums, k);

        System.out.print("[");
        for (int i = 0; i < res.length; i++) {
            if (i != res.length - 1)
                System.out.print(res[i] + ", ");
            else
                System.out.print(res[i]);
        }
        System.out.print("]");
    }
}
