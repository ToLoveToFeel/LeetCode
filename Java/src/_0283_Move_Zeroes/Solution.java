package _0283_Move_Zeroes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution {

    public void moveZeroes(int[] nums) {

        ArrayList<Integer> t = new ArrayList<>();
        for (int num : nums)
            if (num != 0)
                t.add(num);

        for (int i = 0; i < t.size(); i++) nums[i] = t.get(i);
        for (int i = t.size(); i < nums.length; i++) nums[i] = 0;
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};
        (new Solution()).moveZeroes(nums);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }
}
