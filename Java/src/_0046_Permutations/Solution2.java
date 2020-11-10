package _0046_Permutations;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;


public class Solution2 {
    // 时间复杂度：O(n^n)
    // 空间复杂度：O(n)
    private ArrayList<List<Integer>> res;
    private boolean[] used;

    // p中保存了一个有 p.size() 个元素的排列
    // 向这个排列的末尾添加第 p.size()+1 个元素，获得一个有 p.size()+1 个元素的排列
    private void generatePermutation(int[] nums, LinkedList<Integer> p) {
        if (p.size() == nums.length) {
            res.add((LinkedList<Integer>) p.clone());
            return;
        }

        for (int i = 0; i < nums.length; i++)
            if (!used[i]) {
                p.addLast(nums[i]);
                used[i] = true;
                generatePermutation(nums, p);
                p.removeLast();
                used[i] = false;
            }
    }

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return res;

        used = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<>();
        generatePermutation(nums, p);

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = (new Solution2()).permute(nums);

        for (List<Integer> list : res)
            System.out.println(list);
    }
}
