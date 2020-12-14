package _0645_Set_Mismatch;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Date: 2020/12/14 16:02
 * Content:
 * 思路：遍历数组中的元素num，以 num-1 作为下标将 nums[num-1] 取相反数，
 * 出现两次或者零次的数据最终 nums[num-1] > 0, 看数组中数据大于零对应的下标+1即可
 * <p>
 * 执行用时：3 ms, 在所有 Java 提交中击败了70.43%的用户
 * 内存消耗：40 MB, 在所有 Java 提交中击败了70.42%的用户
 */
public class Solution {

    public int[] findErrorNums(int[] nums) {

        int[] res = new int[2];

        for (int num : nums) {  // num 大小在[1...n]之间
            int k = Math.abs(num);
            if (nums[k - 1] < 0) {  // 如果 nums[k - 1] < 0, 说明 k之前出现过了一次
                res[0] = k;
            }
            nums[k - 1] *= -1;
        }

        for (int i = 1; i <= nums.length; i++) {
            // nums[i-1] > 0 说明 i 出现了两次或者零次
            if (nums[i - 1] > 0 && i != res[0]) {
                res[1] = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {

//        int[] nums = {1, 2, 2, 4};
        int[] nums = {4, 1, 2, 2};
        int[] res = (new Solution()).findErrorNums(nums);
        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
    }
}
