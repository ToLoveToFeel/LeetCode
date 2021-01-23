package _0135_Candy;

import java.util.Arrays;

/**
 * Date: 2020/12/24 9:13
 * Content: https://leetcode-cn.com/problems/candy/solution/candy-cong-zuo-zhi-you-cong-you-zhi-zuo-qu-zui-da-/
 * 执行用时：3 ms, 在所有 Java 提交中击败了66.08%的用户
 * 内存消耗：40.1 MB, 在所有 Java 提交中击败了13.12%的用户
 */
public class Solution {

    public int candy(int[] ratings) {

        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = n - 1; i >= 1; i--) {
            if (ratings[i - 1] > ratings[i]) {
                right[i - 1] = right[i] + 1;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.max(left[i], right[i]);
        }

        return res;
    }

    public static void main(String[] args) {

//        int[] ratings = {1, 0, 2};  // 5
        int[] ratings = {1, 2, 2};  // 4
        System.out.println((new Solution()).candy(ratings));
    }
}
