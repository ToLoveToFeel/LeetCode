package _0283_Move_Zeroes;

import java.util.LinkedList;

class Solution {
    public void moveZeroes(int[] nums) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        for (int i = 0; i < nums.length; i++)
            if (0 != nums[i])
                linkedList.addLast(nums[i]);
        int length = linkedList.size();
        for (int i = 0; i < length; i++)
            nums[i] = linkedList.removeFirst();

        for (int i = length; i < nums.length; i++)
            nums[i] = 0;

    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        (new Solution()).moveZeroes(nums);
        for (int i = 0; i < nums.length; i++)
            System.out.println(nums[i]);
    }
}
