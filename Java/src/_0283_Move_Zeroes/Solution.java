package _0283_Move_Zeroes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public void moveZeroes(int[] nums) {

        ArrayList<Integer> nonZerosElements = new ArrayList<>();

        for (int i = 0; i < nums.length; i++)
            if (0 != nums[i])
                nonZerosElements.add(nums[i]);

        for (int i = 0; i < nonZerosElements.size(); i++)
            nums[i] = nonZerosElements.get(i);

        for (int i = nonZerosElements.size(); i < nums.length; i++)
            nums[i] = 0;

    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};
        (new Solution()).moveZeroes(nums);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }
}
