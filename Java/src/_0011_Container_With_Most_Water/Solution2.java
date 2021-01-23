package _0011_Container_With_Most_Water;

/**
 * 对撞指针
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 执行用时：4 ms, 在所有 Java 提交中击败了66.63%的用户
 * 内存消耗：40.1 MB, 在所有 Java 提交中击败了25.95%的用户
 */
public class Solution2 {

    public int maxArea(int[] height) {

        int l = 0, r = height.length - 1;
        int res = 0;
        while (l < r) {
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};  // 49
        System.out.println((new Solution2()).maxArea(height));
    }
}
