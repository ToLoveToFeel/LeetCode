package _0410_Split_Array_Largest_Sum;

/**
 * Date: 2021/5/31 17:16
 */
public class Solution {

    public int splitArray(int[] nums, int m) {
        int l = 0, r = Integer.MAX_VALUE;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (check(nums, mid, m)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private boolean check(int[] nums, int mid, int m) {
        int s = 0, cnt = 0;
        for (int x : nums) {
            if (x > mid) return false;  // 这一个数字都无法放进去
            if (s + x > mid) {
                s = x;
                cnt++;
            } else s += x;
        }
        if (s != 0) cnt++;
        return cnt <= m;
    }

    public static void main(String[] args) {

        int[] nums = {7, 2, 5, 10, 8};
        System.out.println((new Solution()).splitArray(nums, 2));  // 18
    }
}
