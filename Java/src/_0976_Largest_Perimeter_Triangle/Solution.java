package _0976_Largest_Perimeter_Triangle;

import java.util.Arrays;

/**
 * Date: 2020/11/29 10:11
 * Content:
 * <p>
 * 执行用时：8 ms, 在所有 Java 提交中击败了97.44%的用户
 * 内存消耗：39.1 MB, 在所有 Java 提交中击败了70.77%的用户
 */
public class Solution {

    public int largestPerimeter(int[] A) {

        if (A.length < 3)
            throw new IllegalArgumentException("Input Error");

        // 第一步：排序
        Arrays.sort(A);

        // 第二步：从大到小依次验证，得到结果
        for (int i = A.length - 3; i >= 0; i--) {
            int edge1 = A[i];  // 长度最小的边
            int edge2 = A[i + 1];
            int edge3 = A[i + 2];  // 长度最大的边
            if (edge1 + edge2 > edge3)
                return edge1 + edge2 + edge3;
        }

        return 0;
    }

    public static void main(String[] args) {

//        int[] A = {2, 1, 2};  // 5
//        int[] A = {1, 2, 1};  // 0
//        int[] A = {3, 2, 3, 4};  // 10
        int[] A = {3, 6, 2, 3};  // 8
        System.out.println((new Solution()).largestPerimeter(A));
    }
}
