package _0724_Find_Pivot_Index;

/**
 * Date: 2020/9/18 10:39
 * Content:
 * 前缀和（动态计算前缀和）
 */
public class Solution2 {

    public int pivotIndex(int[] nums) {

        int s = 0;
        for (int i = 0; i < nums.length; i++) s += nums[i];

        for (int i = 0, ls = 0; i < nums.length; i++) {
            if (ls == s - ls - nums[i]) return i;
            ls += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {-1, -1, -1, 0, 1, 1};
        System.out.println((new Solution2()).pivotIndex(nums));  // 0
    }
}
