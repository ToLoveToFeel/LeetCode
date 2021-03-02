package _0661_Image_Smoother;

import _0000_study._common.Output;

/**
 * Created by WXX on 2021/3/2 9:56
 * 执行用时：8 ms, 在所有 Java 提交中击败了69.62%的用户
 * 内存消耗：39.4 MB, 在所有 Java 提交中击败了68.87%的用户
 */
public class Solution {

    public int[][] imageSmoother(int[][] M) {

        int n = M.length, m = M[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                int s = 0, c = 0;
                for (int x = i - 1; x <= i + 1; x++)
                    for (int y = j - 1; y <= j + 1; y++)
                        if (x >= 0 && x < n && y >= 0 && y < m) {
                            s += M[x][y];
                            c++;
                        }
                res[i][j] = s / c;
            }
        return res;
    }

    public static void main(String[] args) {

        int[][] M = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        Output.OutputBasicArray2D((new Solution()).imageSmoother(M));
    }

}
