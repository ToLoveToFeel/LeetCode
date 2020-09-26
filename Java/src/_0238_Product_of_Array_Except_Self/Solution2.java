package _0238_Product_of_Array_Except_Self;

/**
 * Date: 2020/9/26 11:26
 * Content:
 * 使用数组存储前缀之积 和 后缀之积
 * 原始数组：    2,  3,  4,  5
 * 前缀之积：    1,  2,  6,  24
 * 后缀之积：    60, 20, 5,  1
 * 结果：       60, 40, 30, 24
 *
 * 对 Solution 空间复杂度的优化
 * 时间复杂度：O(3n) = O(n)
 * 空间复杂度：O(n) = O(n)
 */
public class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];  // 存储前缀之积

        // 计算前缀之积, 存储到 res 中
        res[0] = 1;
        for (int i = 1; i < res.length; i++)
            res[i] = res[i - 1] * nums[i - 1];

        int suffix = 1;  // 存储每个后缀之积
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix = suffix * nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 5};
        int[] res = (new Solution2()).productExceptSelf(nums);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
