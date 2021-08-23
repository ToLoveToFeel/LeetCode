package _1646_Get_Maximum_in_Generated_Array;

/**
 * Date: 2021/8/23 10:26
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.2 MB, 在所有 Java 提交中击败了67.31%的用户
 */
public class Solution {

    public int getMaximumGenerated(int n) {

        if (n == 0) return 0;

        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 1; i <= n; i++) {
            if (i * 2 <= n) nums[i * 2] = nums[i];
            if (i * 2 + 1 <= n) nums[i * 2 + 1] = nums[i] + nums[i + 1];
        }

        int res = 0;
        for (int i = 0; i <= n; i++) res = Math.max(res, nums[i]);
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).getMaximumGenerated(7));  // 3
        System.out.println((new Solution()).getMaximumGenerated(2));  // 1
        System.out.println((new Solution()).getMaximumGenerated(3));  // 2
    }
}
