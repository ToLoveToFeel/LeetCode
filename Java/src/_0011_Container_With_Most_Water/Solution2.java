package _0011_Container_With_Most_Water;

public class Solution2 {
    // 对撞指针
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int maxArea(int[] height) {
        assert height.length >= 2;

        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l < r){
//            maxArea = Math.max(maxArea, Math.min(height[l], height[r])* (r - l));
            int area = Math.min(height[l], height[r])* (r - l);
            if (maxArea < area)
                maxArea = area;
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println((new Solution2()).maxArea(height));
    }
}
