package _0046_Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间复杂度：O(n!)
 * 空间复杂度：O(n)
 */
public class Solution3 {

    private ArrayList<List<Integer>> res = new ArrayList<>();

    private void generatePermutation(int[] nums, int index) {

        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums)
                list.add(i);
            res.add(list);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            generatePermutation(nums, index + 1);
            swap(nums, i, index);
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) return res;

        generatePermutation(nums, 0);

        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> res = (new Solution3()).permute(nums);
        for (List<Integer> list : res)
            System.out.println(list);
    }
}
