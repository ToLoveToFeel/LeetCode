package _0229_Majority_Element_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date: 2021/5/4 17:33
 */
public class Solution {
    static final int K = 3;  // 统计出现次数超过n/K下取整的数

    public List<Integer> majorityElement(int[] nums) {

        int[] r = new int[K - 1], c = new int[K - 1];  // r存储值, c存储值出现次数
        Arrays.fill(c, 0);
        for (int x : nums) {
            boolean flag = false;
            for (int i = 0; i < K - 1; i++)
                if (c[i] != 0 && r[i] == x) {
                    c[i]++;
                    flag = true;
                    break;
                }
            if (flag) continue;
            for (int i = 0; i < K - 1; i++)
                if (c[i] == 0) {
                    r[i] = x; c[i]++;
                    flag = true;
                    break;
                }
            if (flag) continue;
            for (int i = 0; i < K - 1; i++) c[i]--;  // 仓库都非空，并且存储的值都不等于x
        }

        Arrays.fill(c, 0);  // 使用c统计r出现的次数
        for (int x : nums) {
            for (int i = 0; i < K - 1; i++)
                if (r[i] == x) {
                    c[i]++;
                    break;
                }
        }

        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < K - 1; i++)
            if (c[i] > n / K) res.add(r[i]);
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 3};
        System.out.println((new Solution()).majorityElement(nums));  // [3]
    }
}
