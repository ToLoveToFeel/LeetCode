package _1738_Find_Kth_Largest_XOR_Coordinate_Value;

import java.util.PriorityQueue;

/**
 * Date: 2021/5/19 9:11
 * 执行用时：278 ms, 在所有 Java 提交中击败了65.45%的用户
 * 内存消耗：166.5 MB, 在所有 Java 提交中击败了41.21%的用户
 */
public class Solution {

    public int kthLargestValue(int[][] matrix, int k) {

        int n = matrix.length, m = matrix[0].length;
        int[][] s = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                s[i][j] = s[i - 1][j] ^ s[i][j - 1] ^ s[i - 1][j - 1] ^ matrix[i - 1][j - 1];

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                heap.add(s[i][j]);
                if (heap.size() > k) heap.remove();
            }
        return heap.peek();
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {5, 2},
                {1, 6},
        };
        System.out.println((new Solution()).kthLargestValue(matrix, 1));  // 7
        System.out.println((new Solution()).kthLargestValue(matrix, 2));  // 5
        System.out.println((new Solution()).kthLargestValue(matrix, 3));  // 4
        System.out.println((new Solution()).kthLargestValue(matrix, 4));  // 0
    }
}
