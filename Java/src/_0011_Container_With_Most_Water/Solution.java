package _0011_Container_With_Most_Water;

/**
 * 暴力解法
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
public class Solution {

    public int maxArea(int[] height) {

        int res = Math.min(height[0], height[1]);
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                res = Math.max(res, Math.min(height[i], height[j]) * (j - i));

        return res;
    }

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println((new Solution()).maxArea(height));
    }
}
