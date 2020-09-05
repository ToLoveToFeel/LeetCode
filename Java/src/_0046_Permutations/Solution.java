package _0046_Permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    // 时间复杂度：O(n^n)
    // 空间复杂度：O(n)
    private ArrayList<List<Integer>> res;
    private boolean[] used;

    // p中保存了一个有index个元素的排列
    // 向这个排列的末尾添加第 index+1 个元素，获得一个有 index+1 个元素的排列
    private void generatePermutation(int[] nums, int index, LinkedList<Integer> p){
        if (index == nums.length){
            res.add((LinkedList<Integer>)p.clone());
            return;
        }

        for (int i = 0; i < nums.length; i++)
            if (!used[i]){
                p.addLast(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1, p);
                p.removeLast();
                used[i] = false;
            }
        return;
    }

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0)
            return res;

        used = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<>();
        generatePermutation(nums, 0, p);

        return res;
    }

    private static void printList(List<Integer> list){
        for(Integer e: list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = (new Solution()).permute(nums);
        for (List<Integer> list:res)
            printList(list);
    }
}
