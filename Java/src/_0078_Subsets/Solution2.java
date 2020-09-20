package _0078_Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/9/20 12:06
 * Content:
 * 位运算
 */
public class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> p = new ArrayList<>();

        int n  = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            p.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0)
                    p.add(nums[i]);
            }
            res.add(new ArrayList<>(p));
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {};
//        int[] nums = {1};
        int[] nums = {1, 2, 3};
        System.out.println((new Solution2()).subsets(nums));
    }
}
