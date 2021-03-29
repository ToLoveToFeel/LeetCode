package _0090_Subsets_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by WXX on 2021/3/29 15:52
 * Leetcode 0078 子集：枚举每个数出现与否
 * 本题可以枚举每个数出现的次数
 * 执行用时：3 ms, 在所有 Java 提交中击败了23.95%的用户
 * 内存消耗：38.9 MB, 在所有 Java 提交中击败了11.68%的用户
 */
public class Solution {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int u) {

        if (u == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }

        int k = u + 1;
        while (k < nums.length && nums[k] == nums[u]) k++;

        for (int i = 0; i <= k - u; i++) {
            dfs(nums, k);
            path.add(nums[u]);
        }

        for (int i = 0; i <= k - u; i++) {
            path.removeLast();
        }
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).subsetsWithDup(new int[]{1, 2, 2}));
    }
}
