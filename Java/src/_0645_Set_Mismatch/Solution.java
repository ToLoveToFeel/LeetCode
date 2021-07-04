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

        for (int x : nums) {  // x 大小在[1...n]之间
            int k = Math.abs(x);
            if (nums[k - 1] < 0) res[0] = k;
            nums[k - 1] *= -1;
        }
        for (int i = 1; i <= nums.length; i++)
            if (nums[i - 1] > 0 && i != res[0]) {
                res[1] = i;
                break;
            }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 4};
        System.out.println(Arrays.toString((new Solution()).findErrorNums(nums)));
    }
}
