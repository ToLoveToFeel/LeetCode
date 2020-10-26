package _1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number;

/**
 * Date: 2020/10/26 8:39
 * Content:
 * 计数排序
 * 执行用时：
 * 1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了95.82%的用户
 */
public class Solution4 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt = new int[101];  // cnt[num]中存储小于等于 num 的数据的数目
        for (int num : nums) {
            cnt[num]++;
        }
        for (int i = 1; i < 100; i++)
            cnt[i] += cnt[i - 1];

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = (nums[i] == 0 ? 0 : cnt[nums[i] - 1]);
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {8, 1, 2, 2, 3};
        int[] nums = {6, 5, 4, 8};
//        int[] nums = {7, 7, 7, 7};
        int[] res = (new Solution4()).smallerNumbersThanCurrent(nums);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
