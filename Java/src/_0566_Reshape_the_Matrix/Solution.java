package _0566_Reshape_the_Matrix;

import _0000_study._common.Output;

/**
 * Date: 2021/2/17 9:12
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：39.8 MB, 在所有 Java 提交中击败了14.39%的用户
 */
public class Solution {

    public int[][] matrixReshape(int[][] nums, int r, int c) {

        int n = nums.length, m = nums[0].length;
        if (n * m != r * c) return nums;
        int[][] res = new int[r][c];
        for (int i = 0; i < n * m; i++)
            res[i / c][i % c] = nums[i / m][i % m];
        return res;
    }

    public static void main(String[] args) {

        int[][] nums = {{1, 2}, {3, 4}};
        Output.OutputBasicArray2D((new Solution()).matrixReshape(nums, 1, 4));  // [[1, 2, 3, 4]]
    }
}
