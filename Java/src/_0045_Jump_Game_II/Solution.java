package _0045_Jump_Game_II;

/**
 * Date: 2021/5/22 21:38
 */
public class Solution {

    public int jump(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = 0;
        for (int i = 1, j = 0; i < n; i++) {
            while (j + nums[j] < i) j++;
            f[i] = f[j] + 1;
        }
        return f[n - 1];
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).jump(new int[]{2, 3, 1, 1, 4}));  // 2
    }
}
