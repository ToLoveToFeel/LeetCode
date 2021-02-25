package _0330_Patching_Array;

/**
 * Date: 2020/12/29 10:13
 * Content: 当前已经可以凑出[0,x)，若下一个数nums[i]<=x，加入；否则加入新数据x
 * https://leetcode-cn.com/problems/patching-array/solution/an-yao-qiu-bu-qi-shu-zu-by-leetcode-solu-klp1/
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了7.86%的用户
 */
public class Solution {

    public int minPatches(int[] nums, int n) {

        long x = 1;
        int i = 0, res = 0;
        while (x <= n) {
            if (i < nums.length && nums[i] <= x) x += nums[i++];
            else {
                x *= 2;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3};
        int n = 6;
        System.out.println((new Solution()).minPatches(nums, n));
    }
}
