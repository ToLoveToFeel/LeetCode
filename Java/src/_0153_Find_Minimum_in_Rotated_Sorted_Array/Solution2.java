package _0153_Find_Minimum_in_Rotated_Sorted_Array;

/**
 * Date: 2020/9/24 13:42
 * Content:
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/xun-zhao-xuan-zhuan-pai-lie-shu-zu-zhong-de-zui-xi/
 */
public class Solution2 {

    public int findMin(int[] nums) {

        if (nums.length == 1 || nums[nums.length - 1] > nums[0])  // 数组长度为1 或者 未旋转
            return nums[0];

        int l = 0, r = nums.length - 1;
        // 在 [l...r] 之间寻找旋转点
        // l ... mid ... r, 我们必须将 mid 前后的数据都进行比较，这样之后更新才是 l = mid + 1 或 r = mid - 1
        while (l <= r) {
            int mid = (r - l) / 2 + l;

            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            if (nums[mid - 1] > nums[mid])  // 不加这句话，测试 {4, 5, 1, 2, 3} 无法通过
                return nums[mid];

            if (nums[mid] > nums[0])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

//        int[] nums = {3, 4, 5, 1, 2};
//        int[] nums = {3, 1, 2};
//        int[] nums = {3, 1};
//        int[] nums = {3, 4, 1};
//        int[] nums = {4, 5, 1, 2, 3};
        int[] nums = {2, 3, 4, 5, 1};
        System.out.println((new Solution2()).findMin(nums));
    }
}
