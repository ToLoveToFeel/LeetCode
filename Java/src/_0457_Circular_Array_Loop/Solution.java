package _0457_Circular_Array_Loop;

/**
 * Date: 2021/6/5 15:32
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.8 MB, 在所有 Java 提交中击败了81.61%的用户
 */
public class Solution {

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length, Base = 10000;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= Base) continue;
            int k = i, S = Base + i;
            boolean sign = nums[i] > 0;
            int last = -1;
            do {
                int p = ((k + nums[k]) % n + n) % n;
                last = nums[k];
                nums[k] = S;
                k = p;
            } while (k != i && nums[k] < Base && sign == nums[k] > 0);
            if (last % n != 0 && nums[k] == S) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = {2, -1, 1, 2, 2};
        System.out.println((new Solution()).circularArrayLoop(nums));  // true
    }
}
