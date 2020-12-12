package _0376_Wiggle_Subsequence;

/**
 * Date: 2020/12/12 15:01
 * Content: 动态规划
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.9 MB, 在所有 Java 提交中击败了79.50%的用户
 */
public class Solution {

    public int wiggleMaxLength(int[] nums) {

        int n = nums.length;
        int down = 1;  // 代表 摆动子序列中最后两个元素是下降的 子序列长度
        int up = 1;  // 代表 摆动子序列中最后两个元素是上升的 子序列长度

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                up = down + 1;
            } else if (nums[i - 1] > nums[i]) {
                down = up + 1;
            }
        }

        return n == 0 ? 0 : Math.max(down, up);
    }

    public static void main(String[] args) {

//        int[] nums = {1, 7, 4, 9, 2, 5};  // 6
//        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};  // 7
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};  // 2
        int[] nums = {0, 0};  // 0
        System.out.println((new Solution()).wiggleMaxLength(nums));
    }
}
