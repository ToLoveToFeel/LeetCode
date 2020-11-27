package _0016_3Sum_Closest;

import java.util.Arrays;

/**
 * 双指针
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {

        assert nums.length >= 3;

        // 数组首先排序
        Arrays.sort(nums);

        int diff = Math.abs(nums[0] + nums[1] + nums[2] - target);  // 当前考察值和目标值的差距
        int res = nums[0] + nums[1] + nums[2];  // 当前最好结果

        for (int i = 0; i < nums.length; i++) {
            // 双索引 对于每个nums[i]：不断考察nums[l] 和 nums[r]
            int l = i + 1;
            int r = nums.length - 1;
            int t = target - nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == t)
                    return nums[i] + nums[l] + nums[r];
                else {
                    if (Math.abs(nums[l] + nums[r] - t) < diff) {
                        diff = Math.abs(nums[l] + nums[r] - t);
                        res = nums[i] + nums[l] + nums[r];
                    } else if (nums[l] + nums[r] < t)
                        l++;
                    else
                        r--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println((new Solution()).threeSumClosest(nums, target));
    }
}
