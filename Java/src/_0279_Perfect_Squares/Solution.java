package _0279_Perfect_Squares;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 执行用时：11 ms, 在所有 Java 提交中击败了94.53%的用户
 * 内存消耗：38 MB, 在所有 Java 提交中击败了27.87%的用户
 */
public class Solution {

    private static class MyPair {
        int x, y;

        public MyPair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numSquares(int n) {

        if (n == 0) return 0;

        Deque<MyPair> queue = new ArrayDeque<>();  // (数字，n经过的 步数 到达该数字)
        queue.add(new MyPair(n, 0));
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;
        while (!queue.isEmpty()) {
            MyPair front = queue.remove();
            int num = front.x, step = front.y;

            for (int i = 1; ; i++) {
                int a = num - i * i;
                if (a < 0) break;
                if (a == 0) return step + 1;
                if (!visited[a]) {
                    queue.addLast(new MyPair(a, step + 1));
                    visited[a] = true;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).numSquares(12));
        System.out.println((new Solution()).numSquares(13));
    }
}
