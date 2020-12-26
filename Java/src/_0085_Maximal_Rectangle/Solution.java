package _0085_Maximal_Rectangle;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 2020/12/26 14:44
 * Content: 具体细节可以参考 Leetcode 0084
 * https://leetcode-cn.com/problems/maximal-rectangle/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-1-8/
 * 执行用时：13 ms, 在所有 Java 提交中击败了36.31%的用户
 * 内存消耗：41.9 MB, 在所有 Java 提交中击败了39.80%的用户
 */
public class Solution {

    public int maximalRectangle(char[][] matrix) {

        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;

        // h 存储的是高度
        int[] h = new int[n + 2];  // h[0] = 0 为了计算宽度；h[n + 1] = 0为了让单调非严格递增栈出栈
        h[0] = 0;  // 为了计算最小的数据形成的矩形的宽度
        h[n + 1] = 0;  // 最后一项为哨兵项，为了使数据出栈

        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < m; i++) {

            stack.clear();
            stack.push(0);  // 放入哨兵项，这个哨兵的目的是：在下面的while循环中可以不用进行非空判断
            // 每求一个高度就进行栈的操作
            for (int j = 1; j < h.length; j++) {
                if (j <= n) {  // 多申请了 2 个元素，所以要判断
                    if (matrix[i][j - 1] == '1') h[j] += 1;
                    else h[j] = 0;
                }
                while (h[stack.peek()] > h[j]) {
                    int curHeight = h[stack.pop()];
                    int curWidth = j - stack.peek() - 1;
                    res = Math.max(res, curHeight * curWidth);
                }
                stack.push(j);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println((new Solution()).maximalRectangle(matrix));
    }
}
