package _0046_Permutations;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class Solution2 {
    // 时间复杂度：O(n!)
    // 空间复杂度：O(n)
    private ArrayList<List<Integer>> res;

    private void generatePermutation(int[] nums, int index){

        if(index == nums.length){
            List<Integer> list = new ArrayList<Integer>();
            for(int i : nums)
                list.add(i);
            res.add(list);
            return;
        }

        for(int i = index ; i < nums.length ; i ++){
            swap(nums, i, index);
            generatePermutation(nums, index + 1);
            swap(nums, i, index);
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return res;

        generatePermutation(nums, 0);

        return res;
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private static void printList(List<Integer> list){
        for(Integer e: list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> res = (new Solution2()).permute(nums);
        for(List<Integer> list: res)
            printList(list);
    }
}
