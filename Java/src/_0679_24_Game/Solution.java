package _0679_24_Game;

/**
 * Created by WXX on 2021/3/9 9:08
 * 执行用时：3 ms, 在所有 Java 提交中击败了75.91%的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了47.76%的用户
 */
public class Solution {

    // 返回删除nums[i], nums[j]且添加x后的数组
    double[] get(double[] nums, int i, int j, double x) {
        double[] res = new double[nums.length - 1];
        int t = 0;
        for (int k = 0; k < nums.length; k++)
            if (k != i && k != j)
                res[t++] = nums[k];
        res[t] = x;
        return res;
    }

    boolean dfs(double[] nums) {
        if (nums.length == 1) return Math.abs(nums[0] - 24) < 1e-8;
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums.length; j++)
                if (i != j) {
                    double a = nums[i], b = nums[j];
                    if (dfs(get(nums, i, j, a + b))) return true;
                    if (dfs(get(nums, i, j, a - b))) return true;
                    if (dfs(get(nums, i, j, a * b))) return true;
                    if (b != 0 && dfs(get(nums, i, j, a / b))) return true;
                }
        return false;
    }

    public boolean judgePoint24(int[] nums) {
        int n = nums.length;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) a[i] = nums[i];
        return dfs(a);
    }

    public static void main(String[] args) {

        int[] nums = {4, 1, 8, 7};
        System.out.println((new Solution()).judgePoint24(nums));  // true
    }
}
