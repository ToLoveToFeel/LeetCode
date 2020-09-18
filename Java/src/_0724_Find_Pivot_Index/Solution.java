package _0724_Find_Pivot_Index;

/**
 * Date: 2020/9/18 10:39
 * Content:
 */
public class Solution {
    private int[] sum;  // sum[i]存储前i个元素和， sum[0] = 0，sum[i] = sum( [0...i) )

    // nums[i...j]之和
    private int sumRange(int i, int j) {
        if (i > j)
            return 0;
        return sum[j + 1] - sum[i];
    }

    public int pivotIndex(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];
        // 让除头尾的元素作为中心索引，判断是否满足题目条件
        for (int i = 0; i < nums.length; i++) {
            if (sumRange(0, i - 1) == sumRange(i + 1, nums.length - 1))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 7, 3, 6, 5, 6};  // 3
//        int[] nums = {};  // -1
//        int[] nums = {1};  // -1
//        int[] nums = {1, 2, 3};
        int[] nums = {-1, -1, -1, 0, 1, 1};
        System.out.println((new Solution()).pivotIndex(nums));
    }
}
