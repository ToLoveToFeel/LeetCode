package _0477_Total_Hamming_Distance;

/**
 * Date: 2021/5/28 9:17
 * 执行用时：18 ms, 在所有 Java 提交中击败了50.00%的用户
 * 内存消耗：39.7 MB, 在所有 Java 提交中击败了8.22%的用户
 */
public class Solution {

    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i = 0; i <= 30; i++) {
            int x = 0, y = 0;
            for (int c : nums)
                if ((c >> i & 1) == 1) x++;
                else y++;
            res += x * y;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {4, 12, 2};
        System.out.println((new Solution()).totalHammingDistance(nums));  // 6
    }
}
