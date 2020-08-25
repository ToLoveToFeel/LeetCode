package _0007_Reverse_Integer;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 2020/8/25 9:13
 * Content:
 * 时间复杂度：O(length(x))
 * 空间复杂度：O(length(x))
 */
public class Solution {
    public int reverse(int x) {
        long res = 0L;
        Queue<Integer> queue = new LinkedList<>();
        boolean flag = (x >= 0);
        if (!flag)
            x = -x;

        while (x > 0) {
            queue.offer(x % 10);
            x /= 10;
        }
        while (!queue.isEmpty()) {
            res = res * 10 + queue.poll();
        }
        if (!flag)
            res = -res;

        return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) ? 0 : (int) res;
    }

    public static void main(String[] args) {
        int x = -123;
        System.out.println((new Solution()).reverse(x));
    }
}
