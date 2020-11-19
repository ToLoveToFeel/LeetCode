package _0283_Move_Zeroes;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution3 {
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public void moveZeroes(int[] nums) {

        int k = 0;  // nums中，[0...k)的元素均为非零元素

        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                if (i != k)
                    swap(nums, k++, i);
                else
                    k++;

    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};
        (new Solution3()).moveZeroes(nums);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }
}
