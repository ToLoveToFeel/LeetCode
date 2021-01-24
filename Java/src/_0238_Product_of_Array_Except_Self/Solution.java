package _0238_Product_of_Array_Except_Self;

/**
 * Date: 2020/9/26 11:26
 * Content:
 * 使用数组存储前缀之积 和 后缀之积
 * 原始数组：    2,  3,  4,  5
 * 前缀之积：    1,  2,  6,  24
 * 后缀之积：    60, 20, 5,  1
 * 结果：       60, 40, 30, 24
 * <p>
 * 时间复杂度：O(3n) = O(n)
 * 空间复杂度：O(3n) = O(n)
 */
public class Solution {

    public int[] productExceptSelf(int[] nums) {

        int[] prefix = new int[nums.length];  // 存储前缀之积
        int[] suffix = new int[nums.length];  // 存储后缀之积

        // 计算前缀之积
        prefix[0] = 1;
        for (int i = 1; i < prefix.length; i++)
            prefix[i] = prefix[i - 1] * nums[i - 1];
        // 计算后缀之积
        suffix[suffix.length - 1] = 1;
        for (int i = suffix.length - 2; i >= 0; i--)
            suffix[i] = suffix[i + 1] * nums[i + 1];

        // 计算结果
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            res[i] = prefix[i] * suffix[i];

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 5};
        int[] res = (new Solution()).productExceptSelf(nums);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
