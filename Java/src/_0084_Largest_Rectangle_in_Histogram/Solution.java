package _0084_Largest_Rectangle_in_Histogram;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 2020/9/14 19:24
 * Content:
 * 单调栈
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * <p>
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode-/
 * 视频讲解
 *
 * 单调栈问题
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0)
            return 0;
        if (heights.length == 1)
            return heights[0];

        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;  // 为了计算最小的数据形成的矩形的宽度
        newHeights[newHeights.length - 1] = 0;  // 最后一项为哨兵项，为了使数据出栈
        System.arraycopy(heights, 0, newHeights, 1, heights.length);

        Deque<Integer> stack = new ArrayDeque<>();  // 存储的是递增（不用严格递增）数据的索引
        stack.push(0);  // 放入哨兵项，这个哨兵的目的是：在下面的while循环中可以不用进行非空判断
        int res = 0;
        for (int i = 1; i < newHeights.length; i++) {
            while (newHeights[stack.peek()] > newHeights[i]) {
                int curHeight = newHeights[stack.pop()];
                int curWidth = i - stack.peek() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] heights = {2, 1, 5, 6, 2, 3};  // 10
        int[] heights = {2, 1, 2};  // 3
        System.out.println((new Solution()).largestRectangleArea(heights));
    }
}
