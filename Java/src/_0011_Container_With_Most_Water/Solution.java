package _0011_Container_With_Most_Water;

public class Solution {
    // 暴力解法
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(1)
    public int maxArea(int[] height) {
        assert height.length >= 2;

        int area = Math.min(height[0], height[1]);
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                area = Math.max(area, Math.min(height[i], height[j])*(j - i));

        return area;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println((new Solution()).maxArea(height));
    }
}
