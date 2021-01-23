package _0078_Subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Date: 2020/9/20 12:06
 * Content:
 * 递归回溯
 * 和 classicalproblems 中的组合问题 Solution3 比较类似
 */
public class Solution {

    ArrayList<List<Integer>> res = new ArrayList<>();

    // 生成 nums[index...nums.length-1]的子集
    private void dfs(int[] nums, int index, LinkedList<Integer> p) {
        if (index == nums.length) {
            res.add((List<Integer>) p.clone());
            return;
        }
        dfs(nums, index + 1, p);

        p.add(nums[index]);
        dfs(nums, index + 1, p);
        p.removeLast();
    }

    public List<List<Integer>> subsets(int[] nums) {

        LinkedList<Integer> p = new LinkedList<>();
        dfs(nums, 0, p);
        return res;
    }

    public static void main(String[] args) {

//        int[] nums = {};
//        int[] nums = {1};
        int[] nums = {1, 2, 3};
        System.out.println((new Solution()).subsets(nums));
    }
}
