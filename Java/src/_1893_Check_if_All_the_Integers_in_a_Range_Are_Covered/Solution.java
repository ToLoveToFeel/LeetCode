package _1893_Check_if_All_the_Integers_in_a_Range_Are_Covered;

/**
 * Date: 2021/7/23 9:00
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：37.6 MB, 在所有 Java 提交中击败了81.72%的用户
 */
public class Solution {

    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] cnt = new int[60];  // 差分数组
        for (int[] range : ranges) {
            cnt[range[0]]++;
            cnt[range[1] + 1]--;
        }
        for (int i = 1, sum = 0; i <= 50; i++) {
            sum += cnt[i];
            if (i >= left && i <= right && sum <= 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] ranges = {
                {1, 2},
                {3, 4},
                {5, 6},
        };
        System.out.println((new Solution()).isCovered(ranges, 2, 5));  // true
    }
}
